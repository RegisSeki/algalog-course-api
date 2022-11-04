package com.rtseki.algalogcourse.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rtseki.algalogcourse.api.assembler.DeliveryAssembler;
import com.rtseki.algalogcourse.api.model.DeliveryRepresentation;
import com.rtseki.algalogcourse.api.model.request.DeliveryRequest;
import com.rtseki.algalogcourse.domain.model.Delivery;
import com.rtseki.algalogcourse.domain.repository.DeliveryRepository;
import com.rtseki.algalogcourse.domain.service.FinalizationDeliveryService;
import com.rtseki.algalogcourse.domain.service.RequestDeliveryService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries")
public class DeliveryController {
	
	private DeliveryRepository deliveryRepository;
	private RequestDeliveryService requestDeliveryService;
	private FinalizationDeliveryService finalizationDeliveryService;
	private DeliveryAssembler deliveryAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public DeliveryRepresentation request(@Valid @RequestBody DeliveryRequest deliveryRequest) {
		Delivery newDelivery = deliveryAssembler.toEntity(deliveryRequest);
		Delivery requestedDelivery = requestDeliveryService.request(newDelivery);
		return deliveryAssembler.toRepresentation(requestedDelivery);
	}
	
	@GetMapping
	public List<DeliveryRepresentation> listAll() {
		return deliveryAssembler.toCollectionRepresentation(deliveryRepository.findAll());
	}
	
	@GetMapping("/{deliveryId}")
	public ResponseEntity<DeliveryRepresentation> findById(@PathVariable Long deliveryId) {
		return deliveryRepository.findById(deliveryId)
				.map(delivery -> ResponseEntity.ok(deliveryAssembler.toRepresentation(delivery)))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping("/{deliveryId}/finalize")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void finalize(@PathVariable Long deliveryId) {
		finalizationDeliveryService.finalize(deliveryId);
	}
}
