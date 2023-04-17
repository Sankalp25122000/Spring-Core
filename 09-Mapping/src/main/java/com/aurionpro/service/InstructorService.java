package com.aurionpro.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Instructor;

public interface InstructorService {

	ResponseEntity<String> saveInstructor(List<Instructor> data);

	ResponseEntity<String> deleteInstructor(Long id);

	Instructor updateInstructor(Long instructor_id, Long detail_id);

}
