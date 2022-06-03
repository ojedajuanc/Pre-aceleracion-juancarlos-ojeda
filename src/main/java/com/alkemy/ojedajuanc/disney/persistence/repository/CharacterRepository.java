package com.alkemy.ojedajuanc.disney.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.ojedajuanc.disney.persistence.entity.Character;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

}
