package com.repository;

import com.model.entity.Damage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DamageRepository extends JpaRepository<Damage, Integer> {
}
