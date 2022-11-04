package com.rtseki.algalogcourse.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.rtseki.algalogcourse.domain.model.Delivery;
import com.rtseki.algalogcourse.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FinalizationDeliveryService {

	private DeliveryRepository deliveryRepository;
	private FindDeliveryService findDeliveryService;
	
	@Transactional
	public void finalize(Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		
		delivery.finalize();
				
		deliveryRepository.save(delivery);
	}
}
