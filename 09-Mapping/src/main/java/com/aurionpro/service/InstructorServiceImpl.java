package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.Instructor_details;
import com.aurionpro.repository.InstructorRepository;
import com.aurionpro.repository.Instructor_detailsRepository;

@Service
public class InstructorServiceImpl implements InstructorService {

	@Autowired
	private InstructorRepository instructorRepository;
	@Autowired
	private Instructor_detailsRepository instructor_detailsRepository;

	@Override
	public ResponseEntity<String> saveInstructor(List<Instructor> data) {
		instructorRepository.saveAll(data);
		return ResponseEntity.ok("Data saved");
	}

	@Override
	public ResponseEntity<String> deleteInstructor(Long id) {
		instructorRepository.deleteById(id);
		return ResponseEntity.ok("Data deleted");
	}

	@Override
	public Instructor updateInstructor(Long instructor_id, Long detail_id) {
		Instructor instructor = instructorRepository.findById(instructor_id).get();
		Instructor_details instructorDetail = instructor_detailsRepository.findById(detail_id).get();
		instructor.setDetails(instructorDetail);
		instructor_detailsRepository.save(instructor);
		return instructor;
	}

}
