package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.repository.StudentRepository;
import com.aurionpro.service.StudentService;

import jakarta.annotation.PostConstruct;

@RestController   //It tells the below class is RestController with the help of dispatcher(it sends the request to the particular controller)
@RequestMapping("studentapp")  //we have to type it after localhost 8080 using /
public class StudentController {
	
	@Autowired  //it helps to inject bean
	private StudentService studentService;;
	
	@GetMapping("/students")
	public List<Student> findAllStudents(){
		return studentService.findAllStudents();
	}
	
	@GetMapping("/students/{sid}")  //end points should be plurals
	public Student findAllStudentById(@PathVariable(name = "sid")int id){
		return studentService.findStudent(id);
		}
	
	@PostMapping("/students")
	public Student saveStudent(@RequestBody Student student) {
		student.setId(0);
		return studentService.saveStudent(student);
	}
	
	@PutMapping("/students")
	public Student updateStudent(@RequestBody Student student) {
		
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("/students/{stuId}")
	private void deleteStudentById(@PathVariable(name = "stuId")int id) {
	      studentService.deleteStudentById(id);
		}
	@DeleteMapping("/students")
	private void deleteAllStudents() {
		studentService.deleteAll();
		
	}
	
}
