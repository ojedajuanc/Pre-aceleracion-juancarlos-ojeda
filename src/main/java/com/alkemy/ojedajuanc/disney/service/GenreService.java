package com.alkemy.ojedajuanc.disney.service;

import java.util.List;

import com.alkemy.ojedajuanc.disney.domain.GenreDTO;

public interface GenreService {
	
	List<GenreDTO> findAll();

	GenreDTO addGenre(GenreDTO newGenre);

}
