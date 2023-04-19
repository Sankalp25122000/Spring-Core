package com.aurionpro.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Transactional
@Table(name = "instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_id")
	private Long id;
	private String name;
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_instructor_details_id")
	@JsonIgnore
	private Instructor_details details;

//	@JsonIgnore
	@OneToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	@JoinColumn(name = "fk_instructor_id",referencedColumnName = "instructor_id")
//	@JsonIgnoreProperties
	private Set<Course> courses;

	public Instructor() {
		super();
	}

	public Instructor(Long id, String name, String email, Instructor_details details, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.details = details;
		this.courses = new HashSet<>();
	}

	public Instructor_details getDetails() {
		return details;
	}

	public void setDetails(Instructor_details details) {
		this.details = details;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Instructor [id=" + id + ", name=" + name + ", email=" + email + "]";
	}

}
