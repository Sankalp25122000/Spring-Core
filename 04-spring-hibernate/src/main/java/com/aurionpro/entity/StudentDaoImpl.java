package com.aurionpro.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aurionpro.dao.StudentDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired // it will give value from the container
	private EntityManager manager;

//	@Override
//	@Transactional
//	public Student save(Student student) {
//		manager.persist(student);   //It will save to the database the value that we will pass
//		 return manager.find(Student.class, student.getId());
//	}

	@Override
	@Transactional
	public Student save(Student student) {
		manager.persist(student); // It will save to the database the value that we will pass
		return manager.find(Student.class, student.getId());
	}

	@Override
	public Student findById(int id) {
		return manager.find(Student.class, id);

	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = manager.createQuery("select e from Student e ", Student.class);// e is referred as
																									// aliases and we
																									// are firing the
																									// query on Student
																									// class(entity) not
																									// on student
		return query.getResultList();
	}

	@Override
	public List<Student> findByFirstName(String firstName) {
		TypedQuery<Student> query = manager.createQuery("select e from Student e where e.firstName=: theFirstName ",Student.class);
		query.setParameter("theFirstName", firstName);
		return query.getResultList();
	}

	@Override
	public List<Student> findByEmail(String email) {
		TypedQuery<Student> query = manager.createQuery("select e from Student e where e.email=: theEmail ",Student.class);
		query.setParameter("theEmail", email);
		return query.getResultList();
		}

	@Override
	@Transactional
	public void updateStudent(Student student) {
		Student student1 = manager.merge(student);
		System.out.println(student1);
//		TypedQuery<Student> query = manager.createQuery("update Student set firstName =:theFirstName, lastName =: theLastName, email=: theEmail, where id=: theId",Student.class);
//		query.setParameter("theFirstName", student.getFirstName());
//		query.setParameter("theLastName", student.getLastName());
//		query.setParameter("theEmail", student.getEmail());
//		query.setParameter("theId", student.getId());
//		return query.getSingleResult();
	}

	@Override
	@Transactional //it is very important annotation to do add update delete operation in db
	public void deleteStudentById(int id) {
		Student student = manager.find(Student.class, id);
		try {
		manager.remove(student);
		System.out.println("Student removed successfully..");
		
	}catch(Exception e) {
		e.printStackTrace();
	}

}

	@Override
	@Transactional
	public void deleteAll() {
      	int rows = manager.createQuery("delete from Student").executeUpdate();
      	System.out.println(rows);
	}
}
