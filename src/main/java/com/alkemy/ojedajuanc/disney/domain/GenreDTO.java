package com.alkemy.ojedajuanc.disney.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GenreDTO {
	
	private Long id;
	private String nombre;
	private String imagen;
	private List<MediaBasicDTO> catalogo;

}
