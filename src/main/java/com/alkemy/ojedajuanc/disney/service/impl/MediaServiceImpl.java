package com.alkemy.ojedajuanc.disney.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaPostDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaUpdateDTO;
import com.alkemy.ojedajuanc.disney.mapper.MediaMapper;
import com.alkemy.ojedajuanc.disney.persistence.entity.Character;
import com.alkemy.ojedajuanc.disney.persistence.entity.Media;
import com.alkemy.ojedajuanc.disney.persistence.repository.CharacterRepository;
import com.alkemy.ojedajuanc.disney.persistence.repository.MediaRepository;
import com.alkemy.ojedajuanc.disney.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {
	
	@Autowired
	MediaRepository repository;
	@Autowired
	MediaMapper mapper;
	@Autowired
	CharacterRepository characterRespository;

	@Override
	public List<MediaBasicDTO> getAll() {
		return mapper.toListBasicDTO(repository.findAllActive());
	}

	@Override
	public Optional<MediaDTO> getMedia(Long id) {
		return repository.findById(id).map(media -> mapper.toDTO(media));
	}

	@Override
	public MediaDTO createMedia(MediaPostDTO newMedia) {
		// TODO: Validar por MediaType antes que por Title
		if (!newMedia.getTipo().equalsIgnoreCase("PELICULA") && !newMedia.getTipo().equalsIgnoreCase("SERIE")) {
			return null;
		}
		List<Character> cast = new ArrayList<Character>();

		for (Long castId : newMedia.getPersonajes()) {
			characterRespository.findById(castId).ifPresent(character -> cast.add(character));
		}

		Media newMediaEntity = mapper.mediaPostToEntity(newMedia, cast);
		return mapper.toDTO(repository.save(newMediaEntity));
		
		
//		if (repository.findByTitleIgnoreCase(newMedia.getTitulo()) == null) {
//			List<Character> cast = new ArrayList<Character>();
//
//			for (Long castId : newMedia.getPersonajes()) {
//				characterRespository.findById(castId).ifPresent(character -> cast.add(character));
//			}
//
//			Media newMediaEntity = mapper.mediaPostToEntity(newMedia, cast);
//			return mapper.toDTO(repository.save(newMediaEntity));
//		} else {
//			// TODO: retornar badrequest o exception
//			return null;
//		}
	}

	@Override
	public Optional<MediaDTO> updateMedia(Long id, MediaUpdateDTO dto) {
		Media updatedMedia = mapper.mediaUpdateToEntity(dto);
		// Only updates Media if active
		return repository.findByIdAndActiveTrue(id)
			.map(media -> {
				media.setTitle(updatedMedia.getTitle());
				media.setReleaseDate(updatedMedia.getReleaseDate());
				media.setPictureUrl(updatedMedia.getPictureUrl());
				media.setRating(updatedMedia.getRating());
				media.setGenreId(updatedMedia.getGenreId());
				media.setTypeName(updatedMedia.getTypeName());
				return mapper.toDTO(repository.save(media));
			});
	}

}
