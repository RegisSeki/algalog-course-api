package com.rtseki.algalogcourse.domain.service;

import org.springframework.stereotype.Service;

import com.rtseki.algalogcourse.domain.exception.EntityNotFoundException;
import com.rtseki.algalogcourse.domain.model.Delivery;
import com.rtseki.algalogcourse.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FindDeliveryService {

	private DeliveryRepository deliveryRepository;
	
	public Delivery find(Long deliveryId) {
		return  deliveryRepository.findById(deliveryId)
				.orElseThrow(() -> new EntityNotFoundException("Delivery not found"));
	}
}
