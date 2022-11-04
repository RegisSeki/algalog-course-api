package com.rtseki.algalogcourse.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rtseki.algalogcourse.domain.model.Delivery;
import com.rtseki.algalogcourse.domain.service.RequestDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	private RequestDeliveryService requestDeliveryService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Delivery request(@RequestBody Delivery delivery) {
		return requestDeliveryService.request(delivery);
	}
}
