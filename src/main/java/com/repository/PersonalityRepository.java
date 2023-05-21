package com.repository;

import com.model.entity.Personality;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalityRepository extends JpaRepository<Personality, Integer> {
}
