package com.repository;

import com.model.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    List<Equipment> findByCharacterCharacterID(Integer id);
    List<Equipment> findByItemItemID(Integer id);
}
