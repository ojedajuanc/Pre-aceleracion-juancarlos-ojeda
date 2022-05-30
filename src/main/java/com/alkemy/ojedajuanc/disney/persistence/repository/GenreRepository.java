package com.alkemy.ojedajuanc.disney.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.ojedajuanc.disney.persistence.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long>{
	
	Genre findByNameIgnoreCase(String name);

}
