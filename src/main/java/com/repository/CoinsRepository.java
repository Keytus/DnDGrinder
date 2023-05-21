package com.repository;

import com.model.entity.Coins;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoinsRepository extends JpaRepository<Coins, Integer> {
}
