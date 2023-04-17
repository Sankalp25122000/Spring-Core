package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;
import com.aurionpro.exception.NoStudentRecordFoundException;
import com.aurionpro.exception.StudentErrorResponse;
import com.aurionpro.exception.StudentNotFoundException;
import com.aurionpro.repository.StudentRepository;
import com.aurionpro.service.StudentService;

import jakarta.annotation.PostConstruct;

@RestController // It tells the below class is RestController with the help of dispatcher(it
				// sends the request to the particular controller)
@RequestMapping("studentapp") // we have to type it after localhost 8080 using /
public class StudentController {

	@Autowired // it helps to inject bean
	private StudentService studentService;;

	@GetMapping("/students")
	public ResponseEntity<List<Student>> findAllStudents() {
		List<Student> studentList = studentService.findAll();
		//studentList = new ArrayList<Student>();  //only check the working of exception
		if(studentList.size()==0) {
			throw new NoStudentRecordFoundException("No record was found..");
		}
		return new ResponseEntity<>(studentList,HttpStatus.OK);
	}
	
	@RequestMapping(value ="/students/{pageNumber}/{pageSize}", method= RequestMethod.GET)
	public Page<Student> studentPagination(@PathVariable int pageNumber, @PathVariable int pageSize){
		return studentService.getStudentPagination(pageNumber,pageSize);
	}
	
	@RequestMapping(value ="/students/{pageNumber}/{pageSize}/{sortProperty}", method= RequestMethod.GET)
	public Page<Student> studentPagination(@PathVariable int pageNumber, @PathVariable int pageSize, @PathVariable String sortProperty){
		return studentService.getStudentPaginationInSort(pageNumber,pageSize,sortProperty);
	}
	
	

	@GetMapping("/students/{sid}") // end points should be plurals
	public ResponseEntity<Student> findAllStudentById(@PathVariable(name = "sid") int id) {
		Student student = studentService.findById(id);
		return new ResponseEntity<>(student,HttpStatus.OK);
	}

	@PostMapping("/students")
	public ResponseEntity<Student>  saveStudent(@RequestBody Student student) {
		student.setId(0);
		Student saveStudent = studentService.save(student);
		return new ResponseEntity<>(saveStudent,HttpStatus.CREATED);
	}

	@PutMapping("/students")
	public ResponseEntity<Student>  updateStudent(@RequestBody Student student) {
		Student save = studentService.save(student);
		return new ResponseEntity<>(save,HttpStatus.OK);
	}

	@PostMapping("/students/all")
	public List<Student> saveAllStudents(@RequestBody List<Student> studentList) {
		return studentService.saveAll(studentList);
	}

	@DeleteMapping("/students/{stuId}")
	private ResponseEntity<Student> deleteStudentById(@PathVariable(name = "stuId") int id) {
		studentService.deleteById(id);
		return new ResponseEntity<>(null,HttpStatus.OK);
	}

	
	
	
		
	

}
