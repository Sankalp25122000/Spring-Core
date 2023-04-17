package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Employee;
import com.aurionpro.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> findAllEmployees() {
		return repository.findAll();
		
	}

	@Override
	public List<Employee> addEmployees(List<Employee> employees) {
		return repository.saveAll(employees);
	}

	@Override
	public List<Employee> findAllEmployeesByActiveState(Boolean activeState) {
		return repository.findAllEmployeesByActiveState(activeState);
	}

	@Override
	public List<Employee> findByDesignation(List<String> roles) {
		// TODO Auto-generated method stub
		return repository.findEmployeesByDesignation(roles);
	}

	@Override
	public List<Employee> findByDesignationAndActiveState(String designation, Boolean activeState) {
		// TODO Auto-generated method stub
		return repository.findByDesignationAndActiveState(designation,activeState);
	}

	@Override
	public List<Employee> findEmpBySalLessthan50KandActive( Boolean activeState) {
		// TODO Auto-generated method stub
		return repository.findEmpBySalLessthan50KandActive(activeState);
	}

	@Override
	public List<Employee> findEmpByName(String name) {
		// TODO Auto-generated method stub
		return repository.findEmpByName(name);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return repository.getAllRecords();
	}

	@Override
	public List<Employee> findTopEmployeesSalary(int count) {
		return repository.findTopEmployeesSalary(count);
	}
//
//    @Override
//	public List<Employee> findTop3SalariedEmp() {
//		// TODO Auto-generated method stub
//		return repository.findTop3SalariedEmp();
//	}


	

	
	
}
