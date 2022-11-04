package com.rtseki.algalogcourse.api.model;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OccurrenceRepresentation {
	
	private Long id;
	private String description;
	private OffsetDateTime registerDate;
}
