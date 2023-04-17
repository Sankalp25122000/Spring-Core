package com.aurionpro.entity;

import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Transactional
@Table(name = "instructor_details")
public class Instructor_details {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "instructor_details_id")
	private Long id;
	private String youtube_channel;
	private String git_url;

	@OneToOne(mappedBy = "details") // one to one bidirectional
	private Instructor instructor;

	public Instructor_details() {
		super();
	}

	public Instructor_details(Long id, String youtube_channel, String git_url, Instructor instructor) {
		super();
		this.id = id;
		this.youtube_channel = youtube_channel;
		this.git_url = git_url;
		this.instructor = instructor;
	}

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getYoutube_channel() {
		return youtube_channel;
	}

	public void setYoutube_channel(String youtube_channel) {
		this.youtube_channel = youtube_channel;
	}

	public String getGit_url() {
		return git_url;
	}

	public void setGit_url(String git_url) {
		this.git_url = git_url;
	}

	@Override
	public String toString() {
		return "Instructor_details [id=" + id + ", youtube_channel=" + youtube_channel + ", git_url=" + git_url + "]";
	}

}
