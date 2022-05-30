package com.alkemy.ojedajuanc.disney.mapper;

import org.mapstruct.Mapper;

import com.alkemy.ojedajuanc.disney.domain.CharacterBasicDTO;
import com.alkemy.ojedajuanc.disney.persistence.entity.Character;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CharacterMapper {
	
	@Mapping(target = "imagen", source = "pictureUrl")
	@Mapping(target = "nombre", source = "name")
	CharacterBasicDTO toBasicDTO (Character character);

}
