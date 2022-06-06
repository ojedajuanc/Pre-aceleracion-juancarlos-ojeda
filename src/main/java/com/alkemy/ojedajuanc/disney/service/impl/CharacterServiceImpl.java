package com.alkemy.ojedajuanc.disney.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alkemy.ojedajuanc.disney.domain.CharacterBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.CharacterDTO;
import com.alkemy.ojedajuanc.disney.mapper.CharacterMapper;
import com.alkemy.ojedajuanc.disney.persistence.entity.Character;
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

	@Transactional
	@Override
	public void deleteCharacter(Long id) {
		repository.softDeleteById(id);
	}

	@Override
	public Optional<CharacterDTO> createCharacter(CharacterDTO newCharacter) {
		Character newCharacterEntity = mapper.toEntity(newCharacter);
		return Optional.of( mapper.toDTO(repository.save(newCharacterEntity)) );
	}
	
	public Optional<CharacterDTO> updateCharacter(Long id, CharacterDTO dto) {
		Character updatedCharacter = mapper.toEntity(dto);
		// Only updates Character if active
		return repository.findByIdAndActiveTrue(id).map(m -> {
			m.setName(updatedCharacter.getName());
			m.setAge(updatedCharacter.getAge());
			m.setWeight(updatedCharacter.getWeight());
			m.setDescription(updatedCharacter.getDescription());
			m.setPictureUrl(updatedCharacter.getPictureUrl());
			return mapper.toDTO(repository.save(m));
		});
	}

}
