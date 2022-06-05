package com.alkemy.ojedajuanc.disney.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.ojedajuanc.disney.domain.CharacterBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.CharacterDTO;
import com.alkemy.ojedajuanc.disney.mapper.CharacterMapper;
import com.alkemy.ojedajuanc.disney.persistence.repository.CharacterRepository;
import com.alkemy.ojedajuanc.disney.service.CharacterService;

@Service
public class CharacterServiceImpl implements CharacterService {
	
	@Autowired
	CharacterRepository repository;
	@Autowired
	CharacterMapper mapper;

	@Override
	public List<CharacterBasicDTO> getAll() {
		return mapper.toBasicListDTO(repository.findAllActive());
	}

	@Override
	public Optional<CharacterDTO> getCharacter(Long id) {
		return repository.findById(id).map(media -> mapper.toDTO(media));
	}

}
