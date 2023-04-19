package com.aurionpro.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course_table")
public class Course {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long courseId;
  private String courseName;
  private String duration;

  @JsonIgnore
  @ManyToMany(mappedBy = "assignedCourses")
  private Set<Student> student = new HashSet<>();

  public Course() {
    super();
  }

  public Course(Long courseId, String courseName, String duration, Set<Student> student) {
    super();
    this.courseId = courseId;
    this.courseName = courseName;
    this.duration = duration;
    this.student = student;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }

  public Set<Student> getStudent() {
    return student;
  }

  public void setStudent(Set<Student> student) {
    this.student = student;
  }

}