package com.academiamaster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academiamaster.dto.GymDTO;
import com.academiamaster.services.GymService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/gym")
@Tag(name = "Gym", description = "Controller for Gym Owner")
public class GymController {

	@Autowired
	private GymService service;
	
	@Operation(
			description = "Find profit by month", 
			summary = "Find profit by month", 
			responses = {
				@ApiResponse(description = "Ok", responseCode = "200"),
				@ApiResponse(description = "Unauthorized", responseCode = "401"),
				@ApiResponse(description = "Forbidden", responseCode = "403"),
				@ApiResponse(description = "Not Found", responseCode = "404"),
			}
	)
	@SecurityRequirement(name = "bearerAuth")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/profit/{year}/{month}")
	public ResponseEntity<GymDTO> getAllProfitsByMonth(@PathVariable Integer year, @PathVariable Integer month) {
		return new ResponseEntity<>(service.searchGrossProfitByMonth(month, year), HttpStatus.OK);
	}
	
}
