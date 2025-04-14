package com.academiamaster.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academiamaster.dto.GymDTO;
import com.academiamaster.services.GymService;

@RestController
@RequestMapping(value = "/gym")
public class GymController {

	@Autowired
	private GymService service;
	
	@GetMapping(value = "/profit/{year}/{month}")
	public ResponseEntity<GymDTO> getAllProfitsByMonth(@PathVariable Integer year, @PathVariable Integer month) {
		return new ResponseEntity<>(service.searchGrossProfitByMonth(month, year), HttpStatus.OK);
	}
	
}
