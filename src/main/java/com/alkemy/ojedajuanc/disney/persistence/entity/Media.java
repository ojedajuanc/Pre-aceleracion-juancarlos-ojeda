package com.alkemy.ojedajuanc.disney.persistence.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "media")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Media implements Serializable {
	
	private static final long serialVersionUID = -7152909461475382973L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Title cannot be empty")
	@Column(name = "title", nullable = false)
	private String title;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@Column(name = "release_date")
	private LocalDate releaseDate;
	
	@Column(name = "picture")
	private String pictureUrl;
	
	@Positive
	@Max(value = (long) 5, message = "Rating must be a number between 1 and 5") // TODO: Chequear que funcione
	@Column(name = "rating")
	private Double rating;
	
	@NotNull(message = "Genre Id cannot be null")
	@Positive
	@Column(name = "genre_id", nullable = false)
	private Long genreId;
	
	@ManyToOne
	@JsonBackReference
	@JoinColumn(name = "genre_id", insertable = false, updatable = false)
	private Genre genre;
	
	@Column(name = "media_type_name")
	private String typeName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "media_type_name", referencedColumnName = "name", insertable = false, updatable = false)
	private MediaType type;
	
	@Column(name = "active_status")
	private boolean active = true;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "character_media",
			joinColumns = @JoinColumn(name = "media_id"),
			inverseJoinColumns = @JoinColumn(name = "character_id"))
	@Where(clause = "active_status = true")
	private List<Character> cast;
	
	public void addCharacter(Character character) {
		if (this.cast == null) {
			this.cast = new ArrayList<Character>();
		}
		this.cast.add(character);
	}
	
	// TODO: helper method to remove character from cast
	public void removeCharacter(Character character) {
		this.cast.remove(character);
	}

}
