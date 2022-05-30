package com.alkemy.ojedajuanc.disney.mapper;

import org.mapstruct.Mapper;

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.persistence.entity.Media;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MediaMapper {

	@Mapping(target = "fechaCreacion", source = "releaseDate")
	@Mapping(target = "imagen", source = "pictureUrl")
	@Mapping(target = "titulo", source = "title")
	MediaBasicDTO toBasicDTO (Media media);
}
