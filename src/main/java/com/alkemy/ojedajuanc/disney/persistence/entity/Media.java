package com.alkemy.ojedajuanc.disney.persistence.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "media")
public class Media {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "release_date")
	private LocalDate releaseDate;
	
	@Column(name = "picture")
	private String pictureUrl;
	
	@Column(name = "rating")
	private Double rating;
	
	@Column(name = "genre_id", nullable = false)
	private Long genreId;
	
	@Column(name = "media_type_id", nullable = false)
	private int mediaType;
	
	@Column(name = "active")
	private boolean active = false;
	
	private List<Character> cast;

}
