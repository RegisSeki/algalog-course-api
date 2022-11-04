package com.rtseki.algalogcourse.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.rtseki.algalogcourse.domain.exception.BusinessException;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Delivery {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	private Client client;
	
	@Embedded
	private Recipient recipient;
	
	private BigDecimal fee;
	
	@OneToMany(mappedBy = "delivery", cascade = CascadeType.ALL)
	private List<Occurrence> occurrences = new ArrayList<>();
	
	@Enumerated(EnumType.STRING)
	private Status status;
	private OffsetDateTime orderDate;
	private OffsetDateTime finishedDate;
	
	public Occurrence addOccurrence(String description) {
		if (getStatus() == Status.FINISHED) {
			throw new BusinessException("Delivery is finished, cannot add more occurrences");
		}
		
		Occurrence occurrence = new Occurrence();
		occurrence.setDescription(description);
		occurrence.setRegisterDate(OffsetDateTime.now());
		occurrence.setDelivery(this);
		
		this.getOccurrences().add(occurrence);
		
		return occurrence;
	}
	
	public void finalize() {
		if (canNotBeFinalized()) {
			throw new BusinessException("Delivery cannot be finalized");
		}
		
		setStatus(Status.FINISHED);
		setFinishedDate(OffsetDateTime.now());
	}
	
	public boolean canBeFinalized() {
		return Status.PENDING.equals(getStatus());
	}
	
	public boolean canNotBeFinalized() {
		return !canBeFinalized();
	}
}
