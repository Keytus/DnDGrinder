package com.repository;

import com.model.entity.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
    List<Character> findByName(String name);
}
