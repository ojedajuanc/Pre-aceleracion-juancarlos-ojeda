package com.alkemy.ojedajuanc.disney.service;

import java.util.List;
import java.util.Optional;

import com.alkemy.ojedajuanc.disney.domain.CharacterBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.CharacterDTO;

public interface CharacterService {

	List<CharacterBasicDTO> getAll();

	Optional<CharacterDTO> getCharacter(Long id);

	void deleteCharacter(Long id);

	Optional<CharacterDTO> createCharacter(CharacterDTO newCharacter);

}
