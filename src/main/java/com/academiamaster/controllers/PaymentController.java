package com.academiamaster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academiamaster.dto.PaymentDTO;
import com.academiamaster.services.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping(value = "/{year}")
	public ResponseEntity<Page<PaymentDTO>> getPaymentsByYear(Pageable pageable, @PathVariable Integer year) {
		return new ResponseEntity<>(service.findPaymentsPagedByYear(year, pageable), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{year}/{month}")
	public ResponseEntity<List<PaymentDTO>> getPaymentsByMonthAndYear(@PathVariable Integer year, @PathVariable Integer month) {
		return new ResponseEntity<>(service.findByMonthAndYear(month, year), HttpStatus.OK);
	}

	@GetMapping(value = "/{year}/{month}/{day}")
	public ResponseEntity<List<PaymentDTO>> getPaymentsByMonthAndYear(@PathVariable  Integer year, @PathVariable  Integer month, @PathVariable Integer day) {
		return new ResponseEntity<>(service.findByDate(month, year, day), HttpStatus.OK);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<PaymentDTO> insertPayment(@Valid @RequestBody PaymentDTO dto) {
		return new ResponseEntity<>(service.insert(dto), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<PaymentDTO> insertPayment(@Valid @RequestBody PaymentDTO dto, @PathVariable Long id) {
		return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
	}
}
