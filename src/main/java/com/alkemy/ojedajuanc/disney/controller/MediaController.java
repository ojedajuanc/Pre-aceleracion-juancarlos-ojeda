package com.alkemy.ojedajuanc.disney.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.ojedajuanc.disney.domain.MediaBasicDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaPostDTO;
import com.alkemy.ojedajuanc.disney.domain.MediaUpdateDTO;
import com.alkemy.ojedajuanc.disney.service.MediaService;

@RestController
@RequestMapping("catalog")
public class MediaController {
	
	@Autowired
	MediaService service;
	
	// Returns list of all active Media
	@GetMapping("/")
	public ResponseEntity<List<MediaBasicDTO>> getAll() {
		List<MediaBasicDTO> list = service.getAll();
		return new ResponseEntity<List<MediaBasicDTO>>(list, HttpStatus.OK);
	}
	
	// Returns Media by id, even if it is marked as deleted
	@GetMapping("/{id}")
	public ResponseEntity<Optional<MediaDTO>> getMedia(@PathVariable("id") Long id) {
		Optional<MediaDTO> media = service.getMedia(id);
		return new ResponseEntity<Optional<MediaDTO>>(media, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Optional<MediaDTO>> createMedia(@RequestBody MediaPostDTO newMedia) {
		Optional<MediaDTO> savedMedia = Optional.ofNullable(service.createMedia(newMedia));
		if (!savedMedia.isEmpty()) {
			return new ResponseEntity<Optional<MediaDTO>>(savedMedia, HttpStatus.CREATED);
		} else {			
			return new ResponseEntity<Optional<MediaDTO>>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Optional<MediaDTO>> updateMedia(@PathVariable("id") Long id, @RequestBody MediaUpdateDTO media){
		Optional<MediaDTO> updatedMedia = service.updateMedia(id, media);
		return new ResponseEntity<Optional<MediaDTO>>(updatedMedia, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteMedia(@PathVariable Long id) {
		service.deleteMedia(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);		
	}
	
	@GetMapping
	public ResponseEntity<List<MediaBasicDTO>> getMediaByFilters(
			@RequestParam(required = false) String title,
			@RequestParam(required = false) Long genreId,
			@RequestParam(required = false, defaultValue = "DESC") String order) {
		List<MediaBasicDTO> list =  service.getMediaByFilters(title, genreId, order);
		return new ResponseEntity<List<MediaBasicDTO>>(list, HttpStatus.OK);
	}

}
