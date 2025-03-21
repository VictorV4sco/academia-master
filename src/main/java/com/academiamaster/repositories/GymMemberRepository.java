package com.academiamaster.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.academiamaster.entities.GymMember;

public interface GymMemberRepository extends JpaRepository<GymMember, Long>{

}
