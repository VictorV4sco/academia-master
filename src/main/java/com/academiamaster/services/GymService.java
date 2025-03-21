package com.academiamaster.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.academiamaster.dto.GymDTO;
import com.academiamaster.entities.Gym;
import com.academiamaster.mappers.GymMapper;
import com.academiamaster.repositories.GymRepository;

@Service
public class GymService {

	@Autowired
	private GymRepository repository;
	
	@Transactional(readOnly = true)
	public GymDTO findById(Long id) throws Exception {
		Gym gym = repository.findById(id).orElseThrow(() -> new Exception("Recurso não encontrado"));
		return GymMapper.INSTANCE.toDTO(gym);
	}
	
	@Transactional(readOnly = true)
	private Page<GymDTO> findAllPaged(Pageable pageable) {
		Page<Gym> gym = repository.findAll(pageable);
		return GymMapper.INSTANCE.toDTOPage(gym);
	}
}
