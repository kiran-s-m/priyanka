package com.example.springboot3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eid;
	
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	
	@NotEmpty(message = "Designation cannot be empty")
	private String designation;
	
	@Min(value = 15000, message = "Salary should be minimum 15000")
	private int salary;
	
	private String manager_name;
	
	@Pattern(regexp = "[6-9]+[0-9]{9}$", message = "Invalid mobile number")
	private String mobile;
	
	
}
