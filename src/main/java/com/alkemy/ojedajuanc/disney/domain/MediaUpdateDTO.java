package com.alkemy.ojedajuanc.disney.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MediaUpdateDTO {

	private String titulo;
	private LocalDate fechaCreacion;
	private String imagen;
	private Double calificacion;
	private Long idGenero;
	private String tipo;
	
	public String setTipo (String tipo) {
		return this.tipo = tipo.toUpperCase();
	
	}
}
