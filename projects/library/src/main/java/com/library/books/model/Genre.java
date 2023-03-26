package com.library.books.model;

import org.springframework.stereotype.Component;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public enum Genre {
	COMPUTER_SCIENCE,
	MEDICINE,
	BIOLOGY,
	EDUCATION,
	NEUROBIOLOGY,
	AGRICULTURE,
	WILDLIFE,
	MICROBIOLOGY,
	PHSYCHOLOGY,
	MUSIC,
	MOTIVATION;
	
}
