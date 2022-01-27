package com.hoangnam.springmvc.repository;

import com.hoangnam.springmvc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
