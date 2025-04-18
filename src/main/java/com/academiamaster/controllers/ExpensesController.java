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

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/expenses")
public class ExpensesController {

	@Autowired
	private ExpensesService expensesService;
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<ExpensesDTO> getById(@PathVariable Long id) {
		return new ResponseEntity<>(expensesService.findExpensesById(id), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/year/{year}")
	public ResponseEntity<Page<ExpensesDTO>> getPaymentsByYear(Pageable pageable, @PathVariable Integer year) {
		return new ResponseEntity<>(expensesService.findPaymentsPagedByYear(year, pageable), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/year-month/{year}/{month}")
	public ResponseEntity<Page<ExpensesDTO>> getPaymentsByMonth(Pageable pageable, @PathVariable Integer year, @PathVariable Integer month) {
		return new ResponseEntity<>(expensesService.findExpensesPagedByMonth(month, year, pageable), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/year-month-day/{year}/{month}/{day}")
	public ResponseEntity<List<ExpensesDTO>> getPaymentsDay(@PathVariable  Integer year, @PathVariable  Integer month, @PathVariable Integer day) {
		return new ResponseEntity<>(expensesService.findExpensesListedByDay(year, month, day), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping(value = "/new")
	public ResponseEntity<ExpensesDTO> insertExpenses(@Valid @RequestBody ExpensesDTO dto) {
		return new ResponseEntity<>(expensesService.insert(dto), HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/update/{id}")
	public ResponseEntity<ExpensesDTO> updateExpenses(@Valid @RequestBody ExpensesDTO dto, @PathVariable Long id) {
		return new ResponseEntity<>(expensesService.update(id, dto), HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping(value = "/delete/{id}") 
	public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
		expensesService.delete(id);
        return ResponseEntity.noContent().build();
	}
}
