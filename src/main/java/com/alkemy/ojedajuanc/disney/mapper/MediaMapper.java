package com.alkemy.ojedajuanc.disney.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaPostDTO;
import com.alkemy.ojedajuanc.disney.persistence.entity.Character;
import com.alkemy.ojedajuanc.disney.persistence.entity.Media;

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
	@Mapping(target = "tipo", source = "typeName")
	@Mapping(target = "titulo", source = "title")
	@Mapping(target = "imagen", source = "pictureUrl")
	MediaDTO toDTO (Media media);
	
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "type", ignore = true)
	@Mapping(target = "active", ignore = true)
	@Mapping(target = "genre", ignore = true)
	@Mapping(target = "genreId", source = "dto.idGenero")
	@Mapping(target = "pictureUrl", source = "dto.imagen")
	@Mapping(target = "rating", source = "dto.calificacion")
	@Mapping(target = "releaseDate", source = "dto.fechaCreacion")
	@Mapping(target = "title", source = "dto.titulo")
	@Mapping(target = "typeName", source = "dto.tipo")
	@Mapping(target = "cast", source = "cast")
	Media mediaPostToEntity (MediaPostDTO dto, List<Character> cast);
	
}
