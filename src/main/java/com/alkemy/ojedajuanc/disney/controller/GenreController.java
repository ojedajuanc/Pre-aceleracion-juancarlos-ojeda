package com.alkemy.ojedajuanc.disney.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.ojedajuanc.disney.domain.GenreDTO;
import com.alkemy.ojedajuanc.disney.service.GenreService;

@RestController
@RequestMapping("genres")
public class GenreController {
	
	@Autowired
	private GenreService service;
	
	@GetMapping("/")
	public ResponseEntity<List<GenreDTO>> getAll() {
		List<GenreDTO> list = service.findAll();
		return new ResponseEntity<List<GenreDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<GenreDTO> createGenre(@RequestBody GenreDTO newGenre) {
		GenreDTO savedGenre = service.addGenre(newGenre);
		if(savedGenre != null) {
			return new ResponseEntity<GenreDTO>(savedGenre, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<GenreDTO>(HttpStatus.BAD_REQUEST);
		}
	}

}
