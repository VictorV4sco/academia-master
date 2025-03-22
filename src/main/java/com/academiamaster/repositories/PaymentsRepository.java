package com.academiamaster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiamaster.entities.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long>{

}
