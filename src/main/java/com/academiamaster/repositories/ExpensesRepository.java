package com.academiamaster.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academiamaster.entities.Expenses;

public interface ExpensesRepository extends JpaRepository<Expenses, Long>{
	
	@Query("SELECT e FROM Expenses e WHERE FUNCTION('YEAR', e.moment) = :year")
	Page<Expenses> findByYear(@Param("year") Integer year, Pageable pageable);
	
	@Query("SELECT e FROM Expenses e WHERE FUNCTION('MONTH', e.moment) = :month AND FUNCTION('YEAR', e.moment) = :year")
	Page<Expenses> findByMonth(@Param("month") Integer month, @Param("year") Integer year, Pageable pageable);
	
	@Query("SELECT e FROM Expenses e WHERE FUNCTION('MONTH', e.moment) = :month AND FUNCTION('YEAR', e.moment) = :year AND FUNCTION('DAY', e.moment) = :day")
	List<Expenses> findByDay(@Param("month") Integer month, @Param("year") Integer year, @Param("day") Integer day);
}
