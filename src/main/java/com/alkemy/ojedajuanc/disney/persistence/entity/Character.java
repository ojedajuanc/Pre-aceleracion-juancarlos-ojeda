package com.alkemy.ojedajuanc.disney.persistence.entity;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "age")
	private Integer age;
	
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
	private List<Media> filmography;

}
