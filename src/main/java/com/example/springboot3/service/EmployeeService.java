package com.example.springboot3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.springboot3.entity.Employee;
import com.example.springboot3.exception.EmployeeNotFoundException;
import com.example.springboot3.repository.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeServiceMethods {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public ResponseEntity<Employee> employeeSave(Employee e) {
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeRepo.save(e));
	}
	
	@Override
	public ResponseEntity<Object> employeeGet(int eid) {
		Optional<Employee> emp = employeeRepo.findById(eid);
		if(emp.isPresent()) {
			return ResponseEntity.status(200).body(emp);
		}
		else
			throw new EmployeeNotFoundException("No employee found for the ID: "+eid);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepo.findAll();
	}
	
	@Override
	public ResponseEntity<Object> getEmployeeByName(String name) {
		List<Employee> empList = employeeRepo.findByName(name);
		if(empList.size()>0) {
			return ResponseEntity.status(200).body(empList);
		}
		else 
			throw new EmployeeNotFoundException("No employee found for the name: "+name);
	}
	
	
}
