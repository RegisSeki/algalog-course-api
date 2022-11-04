package com.rtseki.algalogcourse.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.rtseki.algalogcourse.api.assembler.OccurrenceAssembler;
import com.rtseki.algalogcourse.api.model.OccurrenceRepresentation;
import com.rtseki.algalogcourse.api.model.request.OccurrenceRequest;
import com.rtseki.algalogcourse.domain.model.Delivery;
import com.rtseki.algalogcourse.domain.model.Occurrence;
import com.rtseki.algalogcourse.domain.service.FindDeliveryService;
import com.rtseki.algalogcourse.domain.service.RegisterOccurrencyService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/deliveries/{deliveryId}/occurrences")
public class OccurrenceController {

	private FindDeliveryService findDeliveryService;
	private RegisterOccurrencyService registerOccurrenceService;
	private OccurrenceAssembler occurrenceAssembler;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OccurrenceRepresentation register(@PathVariable Long deliveryId,
			@Valid @RequestBody OccurrenceRequest occurrenceRequest) {
		
		Occurrence occurrence = registerOccurrenceService.register(deliveryId, occurrenceRequest.getDescription());
	
		return occurrenceAssembler.toModel(occurrence);
	}
	
	@GetMapping
	public List<OccurrenceRepresentation> listAll(@PathVariable Long deliveryId) {
		Delivery delivery = findDeliveryService.find(deliveryId);
		
		return occurrenceAssembler.toCollectionRepresentation(delivery.getOccurrences());
	}
}
