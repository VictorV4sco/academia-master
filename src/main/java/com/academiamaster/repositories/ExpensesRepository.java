package com.academiamaster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiamaster.entities.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Long>{
	
}
