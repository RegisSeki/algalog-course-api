package com.rtseki.algalogcourse.api.model.request;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeliveryRequest {

	@Valid
	@NotNull
	private ClientIdRequest client;
	
	@Valid
	@NotNull
	private RecipientRequest recipient;
	
	@NotNull
	private BigDecimal fee;
}
