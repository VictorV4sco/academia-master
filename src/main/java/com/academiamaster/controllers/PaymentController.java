package com.academiamaster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping(value = "/{month}")
	public ResponseEntity<List<PaymentDTO>> getPaymentsByMonth(@PathVariable Integer month) {
		return new ResponseEntity<>(service.findAllByMonth(month), HttpStatus.OK);
	}
	
	@PostMapping(value = "/new")
	public ResponseEntity<PaymentDTO> insertPayment(@RequestBody PaymentDTO dto) {
		return new ResponseEntity<>(service.insert(dto), HttpStatus.CREATED);
	}
}
