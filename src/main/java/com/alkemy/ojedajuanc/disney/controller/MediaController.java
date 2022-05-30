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

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaDTO;
import com.alkemy.ojedajuanc.disney.service.MediaService;

@RestController
@RequestMapping("catalog")
public class MediaController {
	
	@Autowired
	MediaService service;
	
	@GetMapping("/")
	public ResponseEntity<List<MediaBasicDTO>> getAll() {
		List<MediaBasicDTO> list = service.getAll();
		return new ResponseEntity<List<MediaBasicDTO>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<MediaDTO>> getMedia(@PathVariable("id") Long id) {
		Optional<MediaDTO> media = service.getMedia(id);
		return new ResponseEntity<Optional<MediaDTO>>(media, HttpStatus.OK);
		
	}

}
