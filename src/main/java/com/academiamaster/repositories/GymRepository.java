package com.academiamaster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiamaster.entities.Gym;

public interface GymRepository extends JpaRepository<Gym, Long>{

}
