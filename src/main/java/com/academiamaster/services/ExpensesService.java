package com.academiamaster.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public ExpensesDTO findExpensesById(Long id) {
		Expenses expenses = expensesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
		return new ExpensesDTO(expenses.getId(), expenses.getType(), expenses.getName(), expenses.getValue(), expenses.getMoment());
	}
	
	@Transactional(readOnly = true)
	public Page<ExpensesDTO> findPaymentsPagedByYear(Integer year, Pageable pageable) {
		Page<Expenses> e = expensesRepository.findByYear(year, pageable);
		return e.map(ex -> new ExpensesDTO(ex.getId(), ex.getType(), ex.getName(), ex.getValue(), ex.getMoment()));
	}
	
	@Transactional(readOnly = true)
	public Page<ExpensesDTO> findExpensesPagedByMonth(Integer month, Integer year, Pageable pageable) {
		Page<Expenses> e = expensesRepository.findByMonth(month, year, pageable);
		return e.map(ex -> new ExpensesDTO(ex.getId(), ex.getType(), ex.getName(), ex.getValue(), ex.getMoment()));
	}
	
	@Transactional(readOnly = true)
	public List<ExpensesDTO> findExpensesListedByDay(Integer year, Integer month, Integer day) {
		List<Expenses> e = expensesRepository.findByDay(month, year, day);
		if(e.size() == 0) {
			throw new ResourceNotFoundException("No payments on this day");
		}
		return e.stream().map(ex -> new ExpensesDTO(ex.getId(), ex.getType(), ex.getName(), ex.getValue(), ex.getMoment())).collect(Collectors.toList());
	}

}
