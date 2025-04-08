package com.academiamaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academiamaster.dto.GymDTO;
import com.academiamaster.repositories.GymRepository;

@Service
public class GymService {

	@Autowired
	private GymRepository gymRepository;
	
	@Transactional(readOnly = true)
	public GymDTO searchGrossProfit(Integer month, Integer year) {
		Double totalProfit = gymRepository.sumValuesByMonthAndYear(month, year);
		return new GymDTO(totalProfit);
	}
	
	
}
