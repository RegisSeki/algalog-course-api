package com.rtseki.algalogcourse.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rtseki.algalogcourse.domain.model.Delivery;
import com.rtseki.algalogcourse.domain.repository.DeliveryRepository;
import com.rtseki.algalogcourse.domain.service.RequestDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	private DeliveryRepository deliveryRepository;
	private RequestDeliveryService requestDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery request(@Valid @RequestBody Delivery delivery) {
		return requestDeliveryService.request(delivery);
	}
	
	@GetMapping
	public List<Delivery> listAll() {
		return deliveryRepository.findAll();
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<Delivery> findById(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}