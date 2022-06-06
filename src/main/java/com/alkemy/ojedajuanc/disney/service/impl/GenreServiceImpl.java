package com.alkemy.ojedajuanc.disney.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.ojedajuanc.disney.domain.GenreDTO;
import com.alkemy.ojedajuanc.disney.mapper.GenreMapper;
import com.alkemy.ojedajuanc.disney.persistence.entity.Genre;
import com.alkemy.ojedajuanc.disney.persistence.repository.GenreRepository;
import com.alkemy.ojedajuanc.disney.service.GenreService;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreRepository repository;
	@Autowired
	private GenreMapper mapper;

	@Override
	public List<GenreDTO> findAll() {
		return mapper.toListDTO(repository.findAll());
	}

	@Override
	public GenreDTO addGenre(GenreDTO newGenre) {
		if (repository.findByNameIgnoreCase(newGenre.getNombre()) != null) {
			return null;
		} else {
			Genre newEntity = mapper.toEntity(newGenre);
			return mapper.toDTO(repository.save(newEntity));
		}
	}

}
