package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Course;
import com.aurionpro.entity.Student;
import com.aurionpro.service.StudentCourseService;

@RestController
@RequestMapping("/students/course")
public class StudentCourseController {

	@Autowired
	private StudentCourseService studentCourseService;
	
	@PostMapping("/saveStudent")
	  public ResponseEntity<String> saveStudent(@RequestBody Student data) {
	    return studentCourseService.saveStudent(data);
	  }

	@PostMapping("/saveCourse")
	  public ResponseEntity<String> saveCourse(@RequestBody Course data) {
	    return studentCourseService.saveCourse(data);
	  }
	
	@PutMapping("/updateStudent/{student_id}/courseId/{course_id}")
	public Student updateStudent(@PathVariable Long student_id, @PathVariable Long course_id) {
		return studentCourseService.updateStudent(student_id, course_id);
	}
	
	@GetMapping("/findAllStudents")
	public List<Student> findAllStudents() {
		return studentCourseService.findAllStudents();
	}

	@GetMapping("/findStudentWithId/{studentId}")
	public Student findStudentById(@PathVariable Long studentId) {
		return studentCourseService.findStudentById(studentId);
	}
	
	@DeleteMapping("/deleteStudentById/{studentId}")
	public Student deleteStudentById(@PathVariable Long studentId) {
		return studentCourseService.deleteStudentById(studentId);
	}

}
