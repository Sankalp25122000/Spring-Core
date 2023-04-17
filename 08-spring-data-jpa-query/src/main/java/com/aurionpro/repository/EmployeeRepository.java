package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.aurionpro.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e")
	List<Employee> findAllEmployees();

	// find employees by active state
	@Query("select e from Employee e where e.active=:theActive")
	List<Employee> findAllEmployeesByActiveState(@Param("theActive") Boolean activeState);

	// find employees by the designation //find employees by designation list
	@Query("select e from Employee e where e.designation in ?1")
	List<Employee> findEmployeesByDesignation(List<String> roles);

	// find employees by designation list and active state
	@Query("select e from Employee e where e.designation=:theDesignation and e.active=:theActive")
	List<Employee> findByDesignationAndActiveState(@Param("theDesignation") String designation,
			@Param("theActive") Boolean activeState);

	

	// find all employee having salary less than 50000 and active
	@Query("select e from Employee e where e.salary<='50000' and e.active=:theActive")
	List<Employee> findEmpBySalLessthan50KandActive(@Param("theActive") Boolean activeState);
	

	// find employee by name->List
	@Query("select e from Employee e where e.name =:theName")
	List<Employee> findEmpByName(@Param("theName")String name);

	
	//Named query
	List<Employee> getAllRecords();

	

//	// find top 3 salaries employee
	@Query("select e from Employee e order by e.salary desc limit ?1")
	List<Employee> findTopEmployeesSalary(int count);
//	@Query("select DISTINCT TOP 3 salary FROM Employee ORDER BY salary DESC")
//	List<Employee> findTop3SalariedEmp();
//
//	

}
