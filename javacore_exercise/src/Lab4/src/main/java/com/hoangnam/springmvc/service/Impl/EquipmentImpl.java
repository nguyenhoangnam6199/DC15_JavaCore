package com.hoangnam.springmvc.service.Impl;

import com.hoangnam.springmvc.dto.EmployeeDTO;
import com.hoangnam.springmvc.dto.EquipmentDTO;
import com.hoangnam.springmvc.exception.ConflictException;
import com.hoangnam.springmvc.exception.ResourceNotFoundException;
import com.hoangnam.springmvc.model.Employee;
import com.hoangnam.springmvc.model.Equipment;
import com.hoangnam.springmvc.repository.EmployeeRepository;
import com.hoangnam.springmvc.repository.EquipmentRepository;
import com.hoangnam.springmvc.service.EquipmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EquipmentImpl implements EquipmentService {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<EquipmentDTO> listAllEquipment() {List<Equipment> equipmentList =  equipmentRepository.findAll();
        return  equipmentList.stream().map(equipment -> modelMapper.map(equipment,EquipmentDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EquipmentDTO getEquipmentById(Integer id) {
        Equipment equipment = equipmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Can not find equipment with id = "+id));
        EquipmentDTO equipmentDTO = modelMapper.map(equipment,EquipmentDTO.class);
        return equipmentDTO;
    }

    @Override
    public EquipmentDTO createEquipment(EquipmentDTO equipmentDTO) {
        System.out.println(equipmentDTO.toString());
        Employee employee = employeeRepository.findById(equipmentDTO.getEmployeeId())
                        .orElseThrow(()-> new ResourceNotFoundException("Can not find employee"));
        Equipment equipment = modelMapper.map(equipmentDTO,Equipment.class);
        equipment.setEmployee(employee);
        return new EquipmentDTO(equipmentRepository.save(equipment));

    }

    @Override
    public EquipmentDTO updateEquipment(EquipmentDTO equipmentDTO) {
        Equipment foundEquipment = equipmentRepository.findById(equipmentDTO.getId())
                .orElseThrow(()->new ResourceNotFoundException("Can not find equipment with id= "+equipmentDTO.getId()));
        foundEquipment.setName(equipmentDTO.getName());
        foundEquipment.setStatus(equipmentDTO.getStatus());
        foundEquipment.setDescription(equipmentDTO.getDescription());
        foundEquipment.setType(equipmentDTO.getType());
        Employee employee = employeeRepository.findById(equipmentDTO.getEmployeeId())
                .orElseThrow(()-> new ResourceNotFoundException("Can not find employee"));
        foundEquipment.setEmployee(employee);
        return new EquipmentDTO(equipmentRepository.save(foundEquipment));
    }

    @Override
    public void deleteEquipment(Integer id) {
        Equipment foundEquipment = equipmentRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Can not find equipment with id= "+id));
        equipmentRepository.deleteById(id);
    }
}
