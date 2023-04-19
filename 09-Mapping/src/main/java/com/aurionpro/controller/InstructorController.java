package com.aurionpro.controller;

import java.util.List;
import java.util.Set;

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
import com.aurionpro.entity.Instructor;
import com.aurionpro.service.InstructorService;

@RestController
@RequestMapping("/instructorapp")
public class InstructorController {
//	@Autowired
//	private InstructorRepository instructorRepository;
//	
//	@Autowired
//	private Instructor_detailsRepository insDRepository;

	@Autowired
	private InstructorService instructorService;

	@PostMapping("/saveinstructor")
	public ResponseEntity<String> saveInstructor(@RequestBody List<Instructor> data) {
		return instructorService.saveInstructor(data);
	}

	@PutMapping("/updateInstructor/{instructor_id}/detailid/{detail_id}")
	public Instructor updateInstructor(@PathVariable Long instructor_id, @PathVariable Long detail_id) {
		return instructorService.updateInstructor(instructor_id, detail_id);
	}
	
	@PutMapping("/updateInstructorcourse/{instructor_id}/courseId/{course_id}")
	public Instructor updateInstructorCourse(@PathVariable Long instructor_id, @PathVariable Long course_id) {
		return instructorService.updateInstructorCourse(instructor_id, course_id);
	}
	
	@GetMapping("/getcourseByInstructorId/{instructor_id}")
	public Set<Course> showCourses(@PathVariable Long instructor_id){
		return instructorService.showCourses(instructor_id);
	}
	
	@GetMapping("/getInstructorByCourseId/{course_id}")
	public Instructor showInstructorByCourseId(@PathVariable Long course_id){
		return instructorService.showInstructorByCourse(course_id);
	}

	@DeleteMapping("/deleteinstructor/{id}")
	public ResponseEntity<String> deleteInstructor(@PathVariable Long id) {
		return instructorService.deleteInstructor(id);
	}
}
