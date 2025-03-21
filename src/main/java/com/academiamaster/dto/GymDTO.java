package com.academiamaster.dto;

import java.util.Set;

import com.academiamaster.entities.GymMember;

public record GymDTO(
		Long id,
		Double gross_profit,
		Double net_profit,
		Set<GymMember> gymMembers
		) {

}
