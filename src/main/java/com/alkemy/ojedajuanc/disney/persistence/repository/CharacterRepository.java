package com.alkemy.ojedajuanc.disney.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alkemy.ojedajuanc.disney.persistence.entity.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
	
	Optional<Character> findByIdAndActiveTrue(Long id);
	
	@Query("SELECT u FROM Character u WHERE u.active = true")
	List<Character> findAllActive();
	
	@Modifying
	@Query("UPDATE Character u SET u.active = false WHERE u.id = ?1")
	void softDeleteById(Long id);

}
