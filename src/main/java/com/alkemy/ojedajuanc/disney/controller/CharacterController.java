package com.alkemy.ojedajuanc.disney.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.ojedajuanc.disney.domain.CharacterBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.CharacterDTO;
import com.alkemy.ojedajuanc.disney.service.CharacterService;

@RestController
@RequestMapping("characters")
public class CharacterController {
	
	@Autowired
	CharacterService service;
	
	// Returns list of all active Characters
	@GetMapping("/")
	public ResponseEntity<List<CharacterBasicDTO>> getAll() {
		List<CharacterBasicDTO> list = service.getAll();
		return new ResponseEntity<List<CharacterBasicDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<CharacterDTO>> getCharacter(@PathVariable("id") Long id) {
		Optional<CharacterDTO> character = service.getCharacter(id);
		return new ResponseEntity<Optional<CharacterDTO>>(character, HttpStatus.OK);
	}

}
