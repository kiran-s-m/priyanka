package com.example.springboot3.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot3.entity.Employee;
import com.example.springboot3.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/")
	public ResponseEntity<String> homePage() {
		log.info("Home page is called... ");
		return ResponseEntity.status(200).body("Welcome to EMPLOYEES home page");
	}
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee e) throws JsonParseException {
		log.info("New employee data saved: "+e);
		return employeeService.employeeSave(e);
	}
	
	@GetMapping("/get")
	public ResponseEntity<Object> getEmployee(@RequestHeader int eid) {
		return employeeService.employeeGet(eid);
	}
	
	@GetMapping("/getAll")
	public List<Employee> getAll() {
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/getByName")
	public ResponseEntity<Object> findEmpByName(@RequestHeader String name) {
		return employeeService.getEmployeeByName(name);
	}
	
}
