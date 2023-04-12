package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	//this service layer acts as a medium between studentRepo and student controller which is also standard practice	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAllStudents() {
		return studentRepository.findAllStudents();
	}

	@Override
	public Student findStudent(int id) {
		return studentRepository.findStudent(id);
	}

	@Override
	@Transactional
	public Student saveStudent(Student student) {
		return studentRepository.saveStudent(student);
	}

	@Override
	@Transactional
	public Student updateStudent(Student student) {
		return studentRepository.saveStudent(student);
	}

	@Override
	@Transactional
	public void deleteStudentById(int id) {
	studentRepository.deleteStudentById(id);
		
	}

	@Override
	@Transactional
	public void deleteAll() {
		studentRepository.deleteAllStudents();
	}

}
