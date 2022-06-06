package com.alkemy.ojedajuanc.disney.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CharacterDTO {
	
	private Long id;
	private String nombre;
	private Integer edad;
	private Double peso;
	private String historia;
	private String imagen;
	private List<MediaBasicDTO> filmografia;

}
