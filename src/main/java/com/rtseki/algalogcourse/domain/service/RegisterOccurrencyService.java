package com.rtseki.algalogcourse.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rtseki.algalogcourse.domain.model.Delivery;
import com.rtseki.algalogcourse.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RegisterOccurrencyService {

	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public Occurrence register(Long deliveryId, String description) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		
		return delivery.addOccurrence(description);
	}
}
