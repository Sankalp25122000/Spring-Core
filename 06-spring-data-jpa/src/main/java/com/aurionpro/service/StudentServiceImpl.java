package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	// this service layer acts as a medium between studentRepo and student
	// controller which is also standard practice
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student findById(int id) {
		List<Student> studentList = studentRepository.findAll();
		boolean flag = false;
		for(Student x:studentList) {
			if(x.getId()==id) {
				flag = true;
				break;
			}
		}
		if(flag) {
			return studentRepository.findById(id).get();
		}
		else {
			throw new StudentNotFoundException("Student with id = "+id+" not found");
		}
	}

	@Override
	@Transactional
	public Student save(Student student) {
		return studentRepository.save(student);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		studentRepository.deleteById(id);

	}
	/*
	 * /
	 * 
	 * @Override
	 * 
	 * @Transactional public void deleteAll() {
	 * studentRepository.deleteAllStudents(); }
	 */

	@Override
	public List<Student> saveAll(List<Student> studentList) {
		// TODO Auto-generated method stub
		return studentRepository.saveAll(studentList);
	}

	@Override
	public Page<Student> getStudentPagination(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
		return studentRepository.findAll(pageable);	
	}

	@Override
	public Page<Student> getStudentPaginationInSort(int pageNumber, int pageSize, String sortProperty) {
		Pageable pageable = null;
		if(null!=sortProperty) {
			pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sortProperty);
		}
		else {
		 pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, "name");
		}
		return studentRepository.findAll(pageable);	
	}

	
}
