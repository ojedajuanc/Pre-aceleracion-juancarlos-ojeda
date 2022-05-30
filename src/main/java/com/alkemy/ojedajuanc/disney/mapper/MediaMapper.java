package com.alkemy.ojedajuanc.disney.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaDTO;
import com.alkemy.ojedajuanc.disney.persistence.entity.Media;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CharacterMapper.class)
public interface MediaMapper {

	@Mapping(target = "fechaCreacion", source = "releaseDate")
	@Mapping(target = "imagen", source = "pictureUrl")
	@Mapping(target = "titulo", source = "title")
	MediaBasicDTO toBasicDTO (Media media);
	
	List<MediaBasicDTO> toListBasicDTO (List<Media> list);
	
	@Mapping(target = "calificacion", source = "rating")
	@Mapping(target = "fechaCreacion", source = "releaseDate")
	@Mapping(target = "genero.nombre", source = "genre.name")
	@Mapping(target = "genero.imagen", source = "genre.pictureUrl")
	@Mapping(target = "genero.catalogo", ignore = true)
	@Mapping(target = "personajes", source = "cast")
	@Mapping(target = "tipo", source = "mediaType")
	@Mapping(target = "titulo", source = "title")
	MediaDTO toDTO (Media media);
}
