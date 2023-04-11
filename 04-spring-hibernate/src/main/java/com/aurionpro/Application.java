package com.aurionpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurionpro.dao.StudentDao;
import com.aurionpro.entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner {
	
	@Autowired
	StudentDao studentDao;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//1.addNewStudent();  //to add student
		//2.to find student
//		Student student = findStudentById(1);
//		System.out.println(student);
		
//		//3.to find all student
//		List<Student> students = findAllStudents();
//		System.out.println(students);
//		
//		//4.find student by firstName
//		List<Student> students = findByFirstName("Dhruv");
//		System.out.println(students);
		
		//5.find student by email
//		List<Student> email = findByEmail("dh@gmail.com");
//		System.out.println(email);

	//	6.update student by id
//		updateStudentById(1);
		
//	//	7.delete student by id;
//		deleteStudentById(2);
		
		//8. delete all students
		deleteAllStudents();
		
	}

	private void deleteAllStudents() {
		studentDao.deleteAll();
		
	}

	private void deleteStudentById(int id) {
      studentDao.deleteStudentById(id);
	}

	private void updateStudentById(int id) {
		Student student = new Student(1,"Sankalp","Gaonkar","san@gmail.com");
		studentDao.updateStudent(student);
	}

	private List<Student>findByEmail(String email) {
		
		return studentDao.findByEmail(email);
	}

	private List<Student> findByFirstName(String firstName) {
		
		return studentDao.findByFirstName(firstName);
	}

	private List<Student> findAllStudents() {
		
		return studentDao.findAll();
	}

	private Student findStudentById(int id) {
		return studentDao.findById(id);
		
	}

	private void addNewStudent() {
		Student student = new Student("Dhruv","Rathi","dh@gmail.com");
	       Student resultStudent = studentDao.save(student);	
	       System.out.println(resultStudent);
		
	}

}
