package com.example.springboot3.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.springboot3.entity.Employee;

public interface EmployeeServiceMethods {
	ResponseEntity<Employee> employeeSave(Employee e);
	ResponseEntity<Object> employeeGet(int eid);
	List<Employee> getAllEmployees();
	ResponseEntity<Object> getEmployeeByName(String name);
	
}
