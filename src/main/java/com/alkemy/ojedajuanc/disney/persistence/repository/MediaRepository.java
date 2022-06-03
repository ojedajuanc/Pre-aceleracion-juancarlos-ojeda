package com.alkemy.ojedajuanc.disney.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alkemy.ojedajuanc.disney.persistence.entity.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Long>{
	
	@Query("SELECT u FROM Media u WHERE u.active = true")
	List<Media> findAllActive();
	
	Optional<Media> findByIdAndActiveTrue(Long id);
	
	@Modifying
	@Query("UPDATE Media u SET u.active = false WHERE u.id = ?1")
	void softDelete(Long id);

}
