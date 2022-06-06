package com.alkemy.ojedajuanc.disney.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaPostDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaUpdateDTO;
import com.alkemy.ojedajuanc.disney.mapper.MediaMapper;
import com.alkemy.ojedajuanc.disney.persistence.entity.Character;
import com.alkemy.ojedajuanc.disney.persistence.entity.Media;
import com.alkemy.ojedajuanc.disney.persistence.repository.CharacterRepository;
import com.alkemy.ojedajuanc.disney.persistence.repository.MediaRepository;
import com.alkemy.ojedajuanc.disney.persistence.repository.specification.MediaSpecification;
import com.alkemy.ojedajuanc.disney.pojos.MediaFilter;
import com.alkemy.ojedajuanc.disney.service.MediaService;

@Service
public class MediaServiceImpl implements MediaService {
	
	@Autowired
	MediaRepository repository;
	@Autowired
	MediaMapper mapper;
	@Autowired
	CharacterRepository characterRespository;
	@Autowired
	MediaSpecification mediaSpecification;

	@Override
	public List<MediaBasicDTO> getAll() {
		return mapper.toListBasicDTO(repository.findAllActive());
	}

	@Override
	public Optional<MediaDTO> getMedia(Long id) {
		return repository.findById(id).map(media -> mapper.toDTO(media));
	}

	@Override
	@Transactional
	public MediaDTO createMedia(MediaPostDTO newMedia) {
		if (!newMedia.getTipo().equalsIgnoreCase("PELICULA") && !newMedia.getTipo().equalsIgnoreCase("SERIE")) {
			return null;
		}
		List<Character> cast = new ArrayList<Character>();

		for (Long castId : newMedia.getPersonajes()) {
			// Only adds Characters if they are active
			characterRespository.findByIdAndActiveTrue(castId).ifPresent(character -> cast.add(character));
		}

		Media newMediaEntity = mapper.mediaPostToEntity(newMedia, cast);
		return mapper.toDTO(repository.save(newMediaEntity));
	}

	@Override
	@Transactional
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

	@Override
	@Transactional
	public void deleteMedia(Long id) {
		repository.softDelete(id);
	}

	@Override
	public List<MediaBasicDTO> getMediaByFilters(String title, Long genreId, String order) {
		MediaFilter filter = new MediaFilter(title, genreId, order);
		List<Media> list = repository.findAll(mediaSpecification.getByFilters(filter));
		return mapper.toListBasicDTO(list);
		
	}

	@Override
	@Transactional
	public void addCharacter(Long mediaId, Long characterId) {
		Media media = repository.findByIdAndActiveTrue(mediaId).orElse(null);
		Character character = characterRespository.findByIdAndActiveTrue(characterId).orElse(null);
		
		if (media != null && character != null) {
			media.addCharacter(character);
			repository.save(media);
		}	
	}
	
	@Override
	@Transactional
	public void removeCharacter(Long mediaId, Long characterId) {
		Optional<Character> character = characterRespository.findByIdAndActiveTrue(characterId);
		Optional<Media> media = repository.findByIdAndActiveTrue(mediaId);
		
		if (character.isPresent() && media.isPresent()) {
			media.get().removeCharacter(character.get());
			repository.save(media.get());
		}
	}

}
