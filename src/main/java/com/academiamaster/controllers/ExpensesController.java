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

import com.academiamaster.dto.ExpensesDTO;
import com.academiamaster.services.ExpensesService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/expenses")
@Tag(name = "Expenses", description = "Controller for Expenses")
public class ExpensesController {

	@Autowired
	private ExpensesService expensesService;
	
	@Operation(
			description = "Find expenses by id", 
			summary = "Find expenses by id", 
			responses = {
				@ApiResponse(description = "Ok", responseCode = "200"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/id/{id}", produces = "application/json")
	public ResponseEntity<ExpensesDTO> getById(@PathVariable Long id) {
		return new ResponseEntity<>(expensesService.findExpensesById(id), HttpStatus.OK);
	}
	
	@Operation(
			description = "Find expenses by year", 
			summary = "Find expenses by year", 
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
	public ResponseEntity<Page<ExpensesDTO>> getPaymentsByYear(Pageable pageable, @PathVariable Integer year) {
		return new ResponseEntity<>(expensesService.findPaymentsPagedByYear(year, pageable), HttpStatus.OK);
	}
	
	@Operation(
			description = "Find expenses by month", 
			summary = "Find expenses by month", 
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
	public ResponseEntity<Page<ExpensesDTO>> getPaymentsByMonth(Pageable pageable, @PathVariable Integer year, @PathVariable Integer month) {
		return new ResponseEntity<>(expensesService.findExpensesPagedByMonth(month, year, pageable), HttpStatus.OK);
	}
	
	@Operation(
			description = "Find expenses by day", 
			summary = "Find expenses by day", 
			responses = {
				@ApiResponse(description = "Ok", responseCode = "200"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/year-month-day/{year}/{month}/{day}", produces = "application/json")
	public ResponseEntity<List<ExpensesDTO>> getPaymentsDay(@PathVariable  Integer year, @PathVariable  Integer month, @PathVariable Integer day) {
		return new ResponseEntity<>(expensesService.findExpensesListedByDay(year, month, day), HttpStatus.OK);
	}
	
	@Operation(
			description = "Create a new expense", 
			summary = "Create a new expense", 
			responses = {
				@ApiResponse(description = "Created", responseCode = "201"),
				@ApiResponse(description = "Bad Request", responseCode = "400"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Unprocessable Entity", responseCode = "422") 
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/new", produces = "application/json")
	public ResponseEntity<ExpensesDTO> insertExpenses(@Valid @RequestBody ExpensesDTO dto) {
		return new ResponseEntity<>(expensesService.insert(dto), HttpStatus.CREATED);
	}
	
	@Operation(
			description = "Update a expense", 
			summary = "Update a expense", 
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/update/{id}", produces = "application/json")
	public ResponseEntity<ExpensesDTO> updateExpenses(@Valid @RequestBody ExpensesDTO dto, @PathVariable Long id) {
		return new ResponseEntity<>(expensesService.update(id, dto), HttpStatus.OK);
	}
	
	@Operation(
			description = "Delete a expense", 
			summary = "Delete a expense", 
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
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/delete/{id}", produces = "application/json") 
	public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
		expensesService.delete(id);
        return ResponseEntity.noContent().build();
	}
}
