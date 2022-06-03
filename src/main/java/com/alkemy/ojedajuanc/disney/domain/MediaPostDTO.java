package com.alkemy.ojedajuanc.disney.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MediaPostDTO {

	private String titulo;
	private LocalDate fechaCreacion;
	private String imagen;
	private Double calificacion;
	private List<Long> personajes;
	private Long idGenero;
	private String tipo;
	
	public String setTipo (String tipo) {
		return this.tipo = tipo.toUpperCase();
	
	}
}
