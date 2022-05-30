package com.alkemy.ojedajuanc.disney.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MediaBasicDTO {
	
	private Long id;
	private String titulo;
	private LocalDate fechaCreacion;
	private String imagen;

}
