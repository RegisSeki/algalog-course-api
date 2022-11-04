package com.rtseki.algalogcourse.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.rtseki.algalogcourse.api.model.OccurrenceRepresentation;
import com.rtseki.algalogcourse.domain.model.Occurrence;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class OccurrenceAssembler {

	private ModelMapper modelMapper;
	
	public OccurrenceRepresentation toModel(Occurrence occurrence) {
		return modelMapper.map(occurrence, OccurrenceRepresentation.class);
	}
	
	public List<OccurrenceRepresentation> toCollectionRepresentation(List<Occurrence> occurrences) {
		return occurrences.stream()
				.map(this::toModel)
				.collect(Collectors.toList());
	}
}
