package com.academiamaster.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PaymentDTO(
		@Schema(description = "Database generated payment id")
		Long id,
		
		@Schema(description = "Name of the person who payed")
		@NotBlank(message = "Payername must not be blank")
		@Size(min = 3, max = 30, message = "Payername must have between 3 to 30 characters")
		String payerName,
		
		@Schema(description = "What was payed")
		@NotBlank(message = "Type must not be blank")
		String type,
		
		@Positive(message = "Value must be positive")
		Double value,
		
		@PastOrPresent(message = "Date must not be in the future")
		LocalDateTime paymentMoment
		) {

}
