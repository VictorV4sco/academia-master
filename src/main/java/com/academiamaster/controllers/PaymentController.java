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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academiamaster.dto.PaymentDTO;
import com.academiamaster.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@GetMapping
	public ResponseEntity<Page<PaymentDTO>> getAllPaged(Pageable pageable) {
		return new ResponseEntity<>(service.findAllPaged(pageable), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{year}/{month}")
	public ResponseEntity<List<PaymentDTO>> getPaymentsByMonthAndYear(@PathVariable Integer year, @PathVariable Integer month) {
		return new ResponseEntity<>(service.findByMonthAndYear(month, year), HttpStatus.OK);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<PaymentDTO> insertPayment(@RequestBody PaymentDTO dto) {
		return new ResponseEntity<>(service.insert(dto), HttpStatus.CREATED);
	}
}
