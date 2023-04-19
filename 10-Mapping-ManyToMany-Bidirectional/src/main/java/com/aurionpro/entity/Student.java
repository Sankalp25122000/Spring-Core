package com.aurionpro.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "student_table")
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long studId;
  private String studName;

  @ManyToMany
  // cascade type = helps to UPDATE in child table if any changes which is done inside parent table   
  @JoinTable(name = "student_courses", joinColumns = @JoinColumn(name = "stud_id"), inverseJoinColumns = @JoinColumn(name = "course_id"))
  private Set<Course> assignedCourses = new HashSet<>();

  public Student() {
    super();
  }

  public Student(Long studId, String studName, Set<Course> assignedCourses) {
    super();
    this.studId = studId;
    this.studName = studName;
    this.assignedCourses = assignedCourses;
  }

  public Long getStudId() {
    return studId;
  }

  public void setStudId(Long studId) {
    this.studId = studId;
  }

  public String getStudName() {
    return studName;
  }

  public void setStudName(String studName) {
    this.studName = studName;
  }

  public Set<Course> getAssignedCourses() {
    return assignedCourses;
  }

  public void setAssignedCourses(Set<Course> assignedCourses) {
    this.assignedCourses = assignedCourses;
  }

}