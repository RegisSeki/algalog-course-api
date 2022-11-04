package com.rtseki.algalogcourse.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.rtseki.algalogcourse.api.model.DeliveryRepresentation;
import com.rtseki.algalogcourse.api.model.request.DeliveryRequest;
import com.rtseki.algalogcourse.domain.model.Delivery;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class DeliveryAssembler {

	private ModelMapper modelMapper;
	
	public DeliveryRepresentation toRepresentation(Delivery delivery) {
		return modelMapper.map(delivery, DeliveryRepresentation.class);
	}
	
	public List<DeliveryRepresentation> toCollectionRepresentation(List<Delivery> deliveries) {
		return deliveries.stream()
				.map(this::toRepresentation)
				.collect(Collectors.toList());
	}
	
	public Delivery toEntity(DeliveryRequest deliveryRequest) {
		return modelMapper.map(deliveryRequest, Delivery.class);
	}
}
