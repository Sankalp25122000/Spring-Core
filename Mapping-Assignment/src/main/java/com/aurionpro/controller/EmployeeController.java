package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Employee;
import com.aurionpro.repository.EmployeeRepostitory;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepostitory empRepository;
	
	@PostMapping("/saveEmployees")
	public ResponseEntity<String> saveEmployee(@RequestBody List<Employee> empData){
		empRepository.saveAll(empData);
		return ResponseEntity.ok("Data saved");
	}
}
