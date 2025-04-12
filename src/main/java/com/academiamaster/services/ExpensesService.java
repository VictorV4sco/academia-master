package com.academiamaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academiamaster.dto.ExpensesDTO;
import com.academiamaster.entities.Expenses;
import com.academiamaster.repositories.ExpensesRepository;
import com.academiamaster.services.exceptions.ResourceNotFoundException;

@Service
public class ExpensesService {

	@Autowired
	private ExpensesRepository expensesRepository;
	
	@Transactional(readOnly = true)
	public ExpensesDTO findById(Long id) {
		Expenses expenses = expensesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
		return new ExpensesDTO(expenses.getId(), expenses.getType(), expenses.getName(), expenses.getValue(), expenses.getMoment());
	}
	
	@Transactional(readOnly = true)
	public ExpensesDTO findByYear(Integer year) {
		
		return null;
	}
	
	@Transactional(readOnly = true)
	public ExpensesDTO findByMonth(Integer month) {
		
		return null;
	}
	
	@Transactional(readOnly = true)
	public ExpensesDTO findByDay(Integer day) {
		
		return null;
	}
}
