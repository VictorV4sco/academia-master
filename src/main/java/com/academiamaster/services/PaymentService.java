package com.academiamaster.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academiamaster.dto.PaymentDTO;
import com.academiamaster.entities.Payments;
import com.academiamaster.repositories.PaymentsRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentsRepository repository;
	
	@Transactional(readOnly = true)
	public List<PaymentDTO> findAllByMonth(Integer month) {
		List<Payments> p = repository.findByMonth(month);
		return p.stream().map(pa -> new PaymentDTO(pa.getId(), pa.getPayerName(), pa.getType(), pa.getValue(), pa.getPaymentMoment())).collect(Collectors.toList());	
	}
}
