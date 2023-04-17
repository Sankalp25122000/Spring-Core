package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.Instructor_details;

public interface Instructor_detailsRepository extends JpaRepository<Instructor_details, Long> {

	void save(Instructor instructor);

}
