package com.hoangnam.springmvc.service.Impl;

import com.hoangnam.springmvc.dto.EmployeeDTO;
import com.hoangnam.springmvc.model.Employee;
import com.hoangnam.springmvc.repository.EmployeeRepository;
import com.hoangnam.springmvc.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public List<EmployeeDTO> listAllEmployee() {
        List<Employee> employeeList = employeeRepository.findAll();
        return employeeList.stream().map(employee -> modelMapper.map(employee,EmployeeDTO.class)).collect(Collectors.toList());
    }
}
