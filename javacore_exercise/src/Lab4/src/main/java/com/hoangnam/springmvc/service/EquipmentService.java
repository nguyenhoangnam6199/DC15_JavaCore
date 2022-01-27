package com.hoangnam.springmvc.service;

import com.hoangnam.springmvc.dto.EmployeeDTO;
import com.hoangnam.springmvc.dto.EquipmentDTO;
import com.hoangnam.springmvc.model.Equipment;

import java.util.List;

public interface EquipmentService {
    List<EquipmentDTO> listAllEquipment();
    EquipmentDTO getEquipmentById(Integer id);
    EquipmentDTO createEquipment(EquipmentDTO equipmentDTO);
    EquipmentDTO updateEquipment(EquipmentDTO equipmentDTO);
    void deleteEquipment(Integer id);
}
