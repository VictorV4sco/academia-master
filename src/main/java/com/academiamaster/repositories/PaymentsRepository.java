package com.academiamaster.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.academiamaster.entities.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long>{

	@Query("SELECT p FROM Payments p WHERE FUNCTION('MONTH', p.paymentMoment) = :month AND FUNCTION('YEAR', p.paymentMoment) = :year")
	List<Payments> findByMonthAndYear(@Param("month") Integer month, @Param("year") Integer year);
}
