package com.example.springboot3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot3.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

List<Employee> findByName(String name);

List<Employee> findByNameAndDesignationOrderBySalary(String name, String designation);

List<Employee> findByNameOrDesignation(String name, String designation);

}
