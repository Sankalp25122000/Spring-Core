package com.aurionpro.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository // helps to create bean of below class
public class StudentRepositoryImpl implements StudentRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Student> findAllStudents() {
		TypedQuery<Student> query = entityManager.createQuery("select e from Student e ", Student.class);
		List<Student> resultList = query.getResultList();
		return resultList;

	}

	@Override
	public Student findStudent(int id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public Student saveStudent(Student student) {
		return entityManager.merge(student);

	}

	@Override
	public void deleteStudentById(int id) {
		Student student = entityManager.find(Student.class, id);

		entityManager.remove(student);
	}

	@Override
	public void deleteAllStudents() {
	 	int rows = entityManager.createQuery("delete from Student").executeUpdate();
      	System.out.println("No. of rows affected is "+rows);
		
	}
}
