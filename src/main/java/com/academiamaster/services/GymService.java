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
	public GymDTO searchGrossProfitByMonth(Integer month, Integer year) {
		Double monthProfit = gymRepository.sumValuesByMonthAndYear(month, year);
		return new GymDTO(monthProfit);
	}

	@Transactional(readOnly = true)
	public GymDTO searchGrossProfitByDay(Integer month, Integer year, Integer day) {
		Double dailyProfit = gymRepository.sumValuesByDay(month, year, day);
		return new GymDTO(dailyProfit);
	}
	
}
