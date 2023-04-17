package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Employee;

public interface EmployeeService {

	List<Employee> findAllEmployees();

	List<Employee> addEmployees(List<Employee> employees);

	List<Employee> findAllEmployeesByActiveState(Boolean activeState);


	List<Employee> findByDesignation(List<String> roles);

	List<Employee> findByDesignationAndActiveState(String designation, Boolean activeState);

	List<Employee> findEmpBySalLessthan50KandActive(Boolean activeState);

	List<Employee> findEmpByName(String name);

	List<Employee> getAllEmployees();

	List<Employee> findTopEmployeesSalary(int count);

	List<Employee> findEmployeesByNameList(List<String> names);


//	List<Employee> findTop3SalariedEmp();




}
