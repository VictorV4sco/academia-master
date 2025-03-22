package com.academiamaster.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
	private List<PaymentDTO> findAll() {
		List<Payments> p = repository.findAll(Sort.by("name"));
		return p.stream().map(pa -> new PaymentDTO(pa.getId(), pa.getPayer_name(), pa.getType(), pa.getValue(), pa.getPaymente_moment())).collect(Collectors.toList());	
	}
}
