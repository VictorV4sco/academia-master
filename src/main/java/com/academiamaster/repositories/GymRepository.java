package com.academiamaster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academiamaster.entities.Gym;

public interface GymRepository extends JpaRepository<Gym, Long>{
	
	//Entradas
	
	@Query("SELECT SUM(p.value) FROM Payments p WHERE FUNCTION('MONTH', p.paymentMoment) = :month AND FUNCTION('YEAR', p.paymentMoment) = :year")
	Double sumValuesByMonthAndYear(@Param("month") Integer month, @Param("year") Integer year);
	
	@Query("SELECT SUM(p.value) "
			+ "FROM Payments p WHERE "
			+ "FUNCTION('MONTH', p.paymentMoment) = :month AND FUNCTION('YEAR', p.paymentMoment) = :year AND FUNCTION('DAY', p.paymentMoment) = :day"
			)
	Double sumValuesByDay(@Param("month") Integer month, @Param("year") Integer year, @Param("day") Integer day);
	
	@Query("SELECT SUM(p.value) FROM Payments p WHERE FUNCTION('YEAR', p.paymentMoment) = :year")
	Double sumOfValueByYear(@Param("year") Integer year);
	
	//Saidas
	
	@Query("SELECT SUM(e.value) FROM Expenses e WHERE FUNCTION('MONTH', e.moment) = :month AND FUNCTION('YEAR', e.moment) = :year")
	Double sumExpensesValuesByMonth(@Param("month") Integer month, @Param("year") Integer year);
	
	@Query("SELECT SUM(e.value) "
			+ "FROM Expenses e WHERE "
			+ "FUNCTION('MONTH', e.moment) = :month AND FUNCTION('YEAR', e.moment) = :year AND FUNCTION('DAY', e.moment) = :day"
			)
	Double sumExpensesValuesByDay(@Param("month") Integer month, @Param("year") Integer year, @Param("day") Integer day);
	
	@Query("SELECT SUM(e.value) FROM Expenses e WHERE FUNCTION('YEAR', e.moment) = :year")
	Double sumExpensesValueByYear(@Param("year") Integer year);
}
