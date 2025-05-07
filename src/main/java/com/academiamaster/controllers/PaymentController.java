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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/payments")
@Tag(name = "Payments", description = "Controller for Payments")
public class PaymentController {

	@Autowired
	private PaymentService service;
	
	@Operation(
			description = "Find payments by id", 
			summary = "Find payments by id", 
			responses = {
				@ApiResponse(description = "Ok", responseCode = "200"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public ResponseEntity<PaymentDTO> getById(@PathVariable Long id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@Operation(
			description = "Find all payments in a year", 
			summary = "Find all payments in a year", 
			responses = {
				@ApiResponse(description = "Ok", responseCode = "200"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/year/{year}", produces = "application/json")
	public ResponseEntity<Page<PaymentDTO>> getPaymentsByYear(Pageable pageable, @PathVariable Integer year) {
		return new ResponseEntity<>(service.findPaymentsPagedByYear(year, pageable), HttpStatus.OK);
	}
	
	@Operation(
			description = "Find payments by month", 
			summary = "Find payments by month", 
			responses = {
				@ApiResponse(description = "Ok", responseCode = "200"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/year-month/{year}/{month}", produces = "application/json")
	public ResponseEntity<List<PaymentDTO>> getPaymentsByMonthAndYear(@PathVariable Integer year, @PathVariable Integer month) {
		return new ResponseEntity<>(service.findByMonthAndYear(month, year), HttpStatus.OK);
	}

	@Operation(
			description = "Find payments by day", 
			summary = "Find payments by day", 
			responses = {
				@ApiResponse(description = "Ok", responseCode = "200"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@GetMapping(value = "/year-month-day/{year}/{month}/{day}", produces = "application/json")
	public ResponseEntity<List<PaymentDTO>> getPaymentsByMonthAndYear(@PathVariable  Integer year, @PathVariable  Integer month, @PathVariable Integer day) {
		return new ResponseEntity<>(service.findByDate(month, year, day), HttpStatus.OK);
	}
	
	@Operation(
			description = "Create a new payment", 
			summary = "Create a new payment", 
			responses = {
				@ApiResponse(description = "Created", responseCode = "201"),
				@ApiResponse(description = "Bad Request", responseCode = "400"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Unprocessable Entity", responseCode = "422") 
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@PostMapping(value = "/new", produces = "application/json")
	public ResponseEntity<PaymentDTO> insertPayment(@Valid @RequestBody PaymentDTO dto) {
		return new ResponseEntity<>(service.insert(dto), HttpStatus.CREATED);
	}
	
	@Operation(
			description = "Update a payment", 
			summary = "Update a payment", 
			responses = {
				@ApiResponse(description = "Ok", responseCode = "200"),
				@ApiResponse(description = "Bad Request", responseCode = "400"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
				@ApiResponse(description = "Unprocessable Entity", responseCode = "422") 
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@PutMapping(value = "/update/{id}", produces = "application/json")
	public ResponseEntity<PaymentDTO> updatePayment(@Valid @RequestBody PaymentDTO dto, @PathVariable Long id) {
		return new ResponseEntity<>(service.update(id, dto), HttpStatus.OK);
	}
	
	@Operation(
			description = "Delete a payment", 
			summary = "Delete a payment", 
			responses = {
				@ApiResponse(description = "Sucess", responseCode = "204"),
				@ApiResponse(description = "Bad Request", responseCode = "400"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
				@ApiResponse(description = "Unprocessable Entity", responseCode = "422") 
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_PROFESSOR')")
	@DeleteMapping(value = "/delete/{id}", produces = "application/json") 
	public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
		service.delete(id);
        return ResponseEntity.noContent().build();
	}
}
