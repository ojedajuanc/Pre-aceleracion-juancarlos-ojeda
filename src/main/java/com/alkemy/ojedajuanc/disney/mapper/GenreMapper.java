package com.alkemy.ojedajuanc.disney.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alkemy.ojedajuanc.disney.domain.GenreDTO;
import com.alkemy.ojedajuanc.disney.persistence.entity.Genre;

@Mapper(componentModel = "spring", uses = MediaMapper.class)
public interface GenreMapper {
	
	@Mapping(source = "name", target = "nombre")
	@Mapping(source = "pictureUrl", target = "imagen")
	@Mapping(source = "mediaList", target = "catalogo")
	GenreDTO toDTO (Genre genre);
	
	List<GenreDTO> toListDTO (List<Genre> list);
	
	@Mapping(target = "id", ignore =true)
	@Mapping(target = "mediaList", ignore = true)
	@InheritInverseConfiguration
	Genre toEntity (GenreDTO dto);

}
