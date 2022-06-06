package com.alkemy.ojedajuanc.disney.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character implements Serializable {
	
	private static final long serialVersionUID = 4967899648410358532L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Name cannot be empty")
	@Column(name = "name", nullable = false)
	private String name;
	
	@NotNull(message = "Age cannot be null")
	@PositiveOrZero(message = "Age must be greater or equal than 0")
	@Column(name = "age")
	private Integer age;
	
	@PositiveOrZero(message = "Weight must be greater or equal than 0")
	@Column(name = "weight")
	private Double weight;
	
	@Lob
	@Column(name = "story")
	private String description;
	
	@Column(name = "picture")
	private String pictureUrl;
	
	@Column(name = "active_status")
	private boolean active = true;
	
	@ManyToMany
	@JoinTable(
			name = "character_media",
			joinColumns = @JoinColumn(name = "character_id"),
			inverseJoinColumns = @JoinColumn(name = "media_id")
			)
	@Where(clause = "active_status = true")
	private List<Media> filmography;

}
