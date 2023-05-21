package com.repository;

import com.model.entity.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmorRepository extends JpaRepository<Armor, Integer> {
}
