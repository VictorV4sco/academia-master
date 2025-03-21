package com.academiamaster.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import com.academiamaster.dto.GymDTO;
import com.academiamaster.entities.Gym;

@Mapper
public interface GymMapper {

	GymMapper INSTANCE = Mappers.getMapper(GymMapper.class);
	
	GymDTO toDTO(Gym gym);
	Gym toEntity(GymDTO gymDTO);
	
	List<GymDTO> toDTOList(List<Gym> gym);
	
	default Page<GymDTO> toDTOPage(Page<Gym> gymPage) {
		List<GymDTO> gymDTOs = toDTOList(gymPage.getContent());
        return new PageImpl<>(gymDTOs, gymPage.getPageable(), gymPage.getTotalElements());
      
        //Mapper não consegue mapear tipos como o page, apenas tipo List. Por isso a conversão
	}
	
	// Método adicional para atualizar a entidade com os dados do DTO
	
	@Mapping(target = "id", ignore = true) //Ignora o id (não queremos sobrescrevê-lo)
	void updateFromDTO(GymDTO gymDTO, @MappingTarget Gym gym);
}
