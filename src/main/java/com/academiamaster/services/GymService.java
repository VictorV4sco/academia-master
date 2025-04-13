package com.academiamaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academiamaster.dto.GymDTO;
import com.academiamaster.entities.Gym;
import com.academiamaster.repositories.GymRepository;

@Service
public class GymService {

	@Autowired
	private GymRepository gymRepository;
	
	@Transactional
	public GymDTO searchGrossProfitByMonth(Integer month, Integer year) {
		Double monthGrossProfit = gymRepository.sumValuesByMonthAndYear(month, year);
		Double monthNetProfit = gymRepository.sumExpensesValuesByMonth(month, year);
		Double result = monthGrossProfit-monthNetProfit;
		Gym gym = new Gym();
		gym.setGross_profit(monthGrossProfit);
		gym.setNet_profit(result);
		gym.setMonth(month);
		Gym saved = gymRepository.save(gym);
		return new GymDTO(saved.getGross_profit(), saved.getNet_profit(), saved.getMonth());
	}

//	@Transactional(readOnly = true)
//	public GymDTO searchGrossProfitByYear(Integer year) {
//		Double yearGrossProfit = gymRepository.sumOfValueByYear(year);
//		return new GymDTO(yearGrossProfit);
//	}
//	
//	@Transactional
//	public GymDTO searchNetProfitByMonth(Integer month, Integer year, Integer day) {
//		Double dailyGrossProfit = gymRepository.sumValuesByDay(month, year, day);
//		Double dayNetProfit = gymRepository.sumExpensesValuesByDay(month, year, day);
//		Double result = dailyGrossProfit-dayNetProfit;
//		Gym gym = new Gym();
//		gym.setNet_profit(result);
//		Gym savedNetProfit = gymRepository.save(gym);
//		return new GymDTO(savedNetProfit.getNet_profit());
//	}
	
}
