package com.aurionpro.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Student;

import jakarta.annotation.PostConstruct;

@RestController   //It tells the below class is RestController
@RequestMapping("test")  //we have to type it after localhost 8080 using /
public class TestController {
	
	List<Student> studentList;
	
	@PostConstruct  //it is called after constructor, it is used it to call if we want to insert some values(life cycle method) and it is called only once
	public void init() {
		studentList = new ArrayList<Student>();
		studentList.add(new Student(1,"Aju","Palleri","aju@gmail.com"));
		studentList.add(new Student(2,"Kaju","Nalleri","kaju@gmail.com"));  //both the objects will be converted into BSON format by jackson with the help of spring
	}
	
	@GetMapping("/students")  //end points should be plurals
	public List<Student> findAllStudents(){
		return studentList;
	}
	
	@GetMapping("/students/{studId}")  //end points should be plurals
	public Student findAllStudentById(@PathVariable(name = "studId")int id){
		//return studentList.get(id);
		for(Student x :studentList) {
			if(x.getId()==id) {
				return x;
			}
		}
		return null;
	}
	
	/*
	 * @GetMapping("/hello") // after giving controller path we have to provide this
	 * name = /hello public String showGreetings() { return "Hello All Students"; }
	 * 
	 * @GetMapping("/welcome") // after giving controller path we have to provide
	 * this name = /welcome public String showWelcomemessage() { return
	 * "Welcome to  All Students"; }
	 */


}
