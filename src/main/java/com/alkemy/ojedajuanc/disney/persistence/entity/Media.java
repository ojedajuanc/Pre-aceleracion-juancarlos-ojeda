package com.alkemy.ojedajuanc.disney.persistence.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@Data
@NoArgsConstructor
@AllArgsConstructor
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
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "genre_id", insertable = false, updatable = false)
	private Genre genre;
	
	@Column(name = "media_type_id", nullable = false)
	private Integer mediaType;
	
	@Column(name = "active_status")
	private boolean active = true;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "character_media",
			joinColumns = @JoinColumn(name = "media_id"),
			inverseJoinColumns = @JoinColumn(name = "character_id"))
	private List<Character> cast;

}
