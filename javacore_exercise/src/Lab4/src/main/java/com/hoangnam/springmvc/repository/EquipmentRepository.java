package com.hoangnam.springmvc.repository;

import com.hoangnam.springmvc.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment,Integer> {
    Equipment findByName(String name);
}
