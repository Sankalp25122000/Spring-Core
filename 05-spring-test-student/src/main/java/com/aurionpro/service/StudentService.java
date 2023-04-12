package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentService {
	
	List<Student> findAllStudents();

	Student findStudent(int id);

	Student saveStudent(Student student);

	Student updateStudent(Student student);

	void deleteStudentById(int id);

	void deleteAll();

}
