package com.alkemy.ojedajuanc.disney.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MediaDTO {

	private Long id;
	private String titulo;
	private LocalDate fechaCreacion;
	private Double calificacion;
	private List<CharacterBasicDTO> personajes;
	private GenreDTO genero;
	private Integer tipo;
}
