package com.aurionpro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Course;
import com.aurionpro.entity.Student;

public interface StudentCourseService {

	ResponseEntity<String> saveStudentWtihCourse(List<Student> data);

	List<Student> findAllStudents();

	Student findStudentById(Long studentId);

	ResponseEntity<String> saveStudent(Student data);

	ResponseEntity<String> saveCourse(Course data);

	Student updateStudent(Long student_id, Long course_id);

	Student deleteStudentById(Long studentId);
}
