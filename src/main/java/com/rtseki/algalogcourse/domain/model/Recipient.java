package com.rtseki.algalogcourse.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Recipient {
	
	@NotBlank
	@Column(name = "recipient_name")
	private String name;
	
	@NotBlank
	@Column(name = "recipient_address")
	private String address;
	
	@NotBlank
	@Column(name = "recipient_number")
	private String number;
	
	@Column(name = "recipient_complement")
	private String complement;
	
	@NotBlank
	@Column(name = "recipient_district")
	private String district;
}
