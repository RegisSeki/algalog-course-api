package com.rtseki.algalogcourse.domain.service;

import java.time.OffsetDateTime;

import org.springframework.stereotype.Service;

import com.rtseki.algalogcourse.domain.model.Client;
import com.rtseki.algalogcourse.domain.model.Delivery;
import com.rtseki.algalogcourse.domain.model.Status;
import com.rtseki.algalogcourse.domain.repository.DeliveryRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RequestDeliveryService {
	
	private CatalogClientService catalogClientService;
	private DeliveryRepository deliveryRepository;

	public Delivery request(Delivery delivery) {
		Client client = catalogClientService.findById(delivery.getClient().getId());
		
		delivery.setClient(client);
		delivery.setStatus(Status.PENDING);
		delivery.setOrderDate(OffsetDateTime.now());
		
		return deliveryRepository.save(delivery);
	}	
}
