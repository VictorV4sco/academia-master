package com.academiamaster.dto;

import com.academiamaster.entities.Gym;

public record GymMemberDTO(
		Long id,
		String name,
		Double monthly_fee,
		Gym gym
		) {

}
