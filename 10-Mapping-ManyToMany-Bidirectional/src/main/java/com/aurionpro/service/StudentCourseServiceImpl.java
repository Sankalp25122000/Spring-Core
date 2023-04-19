package com.aurionpro.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Course;
import com.aurionpro.entity.Student;
import com.aurionpro.repository.CourseRepository;
import com.aurionpro.repository.StudentRepository;

@Service
public class StudentCourseServiceImpl implements StudentCourseService {

	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private CourseRepository courseRepository;

	/*
	 * @Override public Student saveStudentWtihCourse(Student student) { return
	 * studentRepository.save(student); }
	 */

	@Override
	public List<Student> findAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student findStudentById(Long studentId) {
		return studentRepository.findById(studentId).orElse(null);
	}

	@Override
	public ResponseEntity<String> saveStudentWtihCourse(List<Student> data) {
		studentRepository.saveAll(data);
		return ResponseEntity.ok("Data saved");
	}

	@Override
	public ResponseEntity<String> saveStudent(Student data) {
		studentRepository.save(data);
		return ResponseEntity.ok("Data saved");
	}

	@Override
	public ResponseEntity<String> saveCourse(Course data) {
		courseRepository.save(data);
		return ResponseEntity.ok("Data saved");
	}

	@Override
	public Student updateStudent(Long student_id, Long course_id) {
        Student student = studentRepository.findById(student_id).get(); 
		Set<Course> courses = student.getAssignedCourses();
		Course course = courseRepository.findById(course_id).get();
		courses.add(course);
		student.setAssignedCourses(courses);
		studentRepository.save(student);
		return student;
	}

	@Override
	public Student deleteStudentById(Long studentId) {
		 studentRepository.deleteById(studentId);
		 return null;
	}

}
