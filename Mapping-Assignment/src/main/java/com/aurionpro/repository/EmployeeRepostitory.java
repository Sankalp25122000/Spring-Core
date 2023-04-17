package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Employee;

public interface EmployeeRepostitory extends JpaRepository<Employee, Long> {

}
