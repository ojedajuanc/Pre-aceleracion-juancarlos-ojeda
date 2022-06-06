package com.alkemy.ojedajuanc.disney.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alkemy.ojedajuanc.disney.domain.CharacterBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.CharacterDTO;
import com.alkemy.ojedajuanc.disney.persistence.entity.Character;

@Mapper(componentModel = "spring", uses = MediaMapper.class)
public interface CharacterMapper {
	
	@Mapping(target = "imagen", source = "pictureUrl")
	@Mapping(target = "nombre", source = "name")
	CharacterBasicDTO toBasicDTO (Character character);
	
	List<CharacterBasicDTO> toBasicListDTO (List<Character> list);
	
	@Mapping(target = "edad", source = "age")
	@Mapping(target = "filmografia", source = "filmography")
	@Mapping(target = "historia", source = "description")
	@Mapping(target = "imagen", source = "pictureUrl")
	@Mapping(target = "nombre", source = "name")
	@Mapping(target = "peso", source = "weight")
	CharacterDTO toDTO (Character character);
	
	@InheritInverseConfiguration
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "active", ignore = true)
	@Mapping(target = "filmography", ignore = true)
	Character toEntity (CharacterDTO dto);

}
