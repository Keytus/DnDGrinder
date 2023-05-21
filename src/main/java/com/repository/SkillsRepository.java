package com.repository;

import com.model.entity.Skills;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillsRepository extends JpaRepository<Skills, Integer> {
}
