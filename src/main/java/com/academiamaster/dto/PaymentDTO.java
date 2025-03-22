package com.academiamaster.dto;

import java.time.LocalDateTime;

public record PaymentDTO(
		Long id,
		String payer_name,
		String type,
		Double value,
		LocalDateTime paymente_moment
		) {

}
