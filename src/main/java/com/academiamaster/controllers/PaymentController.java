package com.academiamaster.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<PaymentDTO> getById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/year/{year}")
	public ResponseEntity<Page<PaymentDTO>> getPaymentsByYear(Pageable pageable, @PathVariable Integer year) {
		return new ResponseEntity<>(service.findPaymentsPagedByYear(year, pageable), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping(value = "/year-month/{year}/{month}")
	public ResponseEntity<List<PaymentDTO>> getPaymentsByMonthAndYear(@PathVariable Integer year, @PathVariable Integer month) {
		return new ResponseEntity<>(service.findByMonthAndYear(month, year), HttpStatus.OK);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@GetMapping(value = "/year-month-day/{year}/{month}/{day}")
	public ResponseEntity<List<PaymentDTO>> getPaymentsByMonthAndYear(@PathVariable  Integer year, @PathVariable  Integer month, @PathVariable Integer day) {
		return new ResponseEntity<>(service.findByDate(month, year, day), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@PostMapping(value = "/new")
	public ResponseEntity<PaymentDTO> insertPayment(@Valid @RequestBody PaymentDTO dto) {
		return new ResponseEntity<>(service.insert(dto), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<PaymentDTO> updatePayment(@Valid @RequestBody PaymentDTO dto, @PathVariable Long id) {
		return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@DeleteMapping(value = "/delete/{id}") 
	public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
		service.delete(id);
        return ResponseEntity.noContent().build();
	}
}
