package com.academiamaster.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academiamaster.entities.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long>{

	@Query("SELECT p FROM Payments p WHERE FUNCTION('MONTH', p.paymentMoment) = :month AND FUNCTION('YEAR', p.paymentMoment) = :year")
	List<Payments> findByMonthAndYear(@Param("month") Integer month, @Param("year") Integer year);
	
	@Query("SELECT p FROM Payments p WHERE FUNCTION('MONTH', p.paymentMoment) = :month AND FUNCTION('YEAR', p.paymentMoment) = :year AND FUNCTION('DAY', p.paymentMoment) = :day")
	List<Payments> findByDay(@Param("month") Integer month, @Param("year") Integer year, @Param("day") Integer day);
	
	@Query("SELECT p FROM Payments p WHERE FUNCTION('YEAR', p.paymentMoment) = :year")
	Page<Payments> findByYear(@Param("year") Integer year, Pageable pageable);
}
