package com.academiamaster.dto;

import java.time.LocalDateTime;

public record PaymentDTO(
		Long id,
		String payerName,
		String type,
		Double value,
		LocalDateTime paymentMoment
		) {

}
