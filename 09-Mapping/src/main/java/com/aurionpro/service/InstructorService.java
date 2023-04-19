package com.aurionpro.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Course;
import com.aurionpro.entity.Instructor;

public interface InstructorService {

	ResponseEntity<String> saveInstructor(List<Instructor> data);

	ResponseEntity<String> deleteInstructor(Long id);

	Instructor updateInstructor(Long instructor_id, Long detail_id);

	Instructor updateInstructorCourse(Long instructor_id, Long course_id);

	Set<Course> showCourses(Long instructor_id);

	Instructor showInstructorByCourse(Long course_id);

}
