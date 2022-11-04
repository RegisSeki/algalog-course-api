package com.rtseki.algalogcourse.api.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RecipientRequest {

	@NotBlank
	private String name;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String number;
	
	private String complement;
	
	@NotBlank
	private String district;
}
