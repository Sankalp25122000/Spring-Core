package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Employee;
import com.aurionpro.service.EmployeeService;
import com.aurionpro.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/empapp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployee(){
		return employeeService.findAllEmployees();
		
	}
	
	@GetMapping("/employees/active/{activeState}")
	public List<Employee> findAllEmployee(@PathVariable Boolean activeState){
		return employeeService.findAllEmployeesByActiveState(activeState);
		
	}
	
	@GetMapping("/employees/designation")
	public List<Employee> findByDesignation(@RequestParam List<String> roles){
		return employeeService.findByDesignation(roles);
	}
	
	@GetMapping("/employees/designation/{designation}/active/{activeState}")
	public List<Employee> findByDesignationAndActiveState(@PathVariable String designation ,@PathVariable Boolean activeState){
		return employeeService.findByDesignationAndActiveState(designation,activeState);
	}
	
	@GetMapping("/employees/salary/active/{activeState}")
	public List<Employee> findEmpBySalLessthan50KandActive(@PathVariable Boolean activeState){
		return employeeService.findEmpBySalLessthan50KandActive(activeState);
	}
	
//	
//	  @GetMapping("/employees/top3salary") public List<Employee>
//	  findTop3SalariedEmp(){ return employeeService.findTop3SalariedEmp(); }
//	 
	
	@GetMapping("/employees/name/{name}")
	public List<Employee> findEmpByName(@PathVariable String name){
		return employeeService.findEmpByName(name);
	}
	
	//Named query
	@GetMapping("/employis")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/employees/topsalary/{count}")
	public List<Employee> findTopEmployeesSalary(@PathVariable int count){
		return employeeService.findTopEmployeesSalary(count);
	}
	
	@GetMapping("/employees/nameList")
	public List<Employee> findEmployeesByNameList(@RequestParam List<String> names) {
		return employeeService.findEmployeesByNameList(names);
	}
	
	
	
	@PostMapping("/employees")
	public List<Employee> addMultipleEmployees(@RequestBody List<Employee> employees){

		return employeeService.addEmployees(employees);
		
	}

}
