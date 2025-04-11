package com.academiamaster.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ExpensesDTO(
		Long id,
		
		@NotBlank(message = "Type must not be blank")
		@Size(min = 2, max = 30, message = "Type must have between 2 to 30 characters")
		String type,
		
		@NotBlank(message = "Name must not be blank")
		@Size(min = 3, max = 30, message = "Name must have between 3 to 30 characters")
		String name,
		
		@Positive(message = "Value must be positive")
		Double value,
		
		@PastOrPresent(message = "Date must not be in the future")
		LocalDateTime moment
		) {

}
