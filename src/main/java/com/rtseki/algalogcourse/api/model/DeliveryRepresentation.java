package com.rtseki.algalogcourse.api.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.rtseki.algalogcourse.domain.model.Status;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRepresentation {
	
	private Long id;
	private ClientShortRepresentation client;
	private RecipientRepresentation recipient;
	private BigDecimal fee;
	private Status status;
	private OffsetDateTime orderDate;
	private OffsetDateTime finishedDate;
}
