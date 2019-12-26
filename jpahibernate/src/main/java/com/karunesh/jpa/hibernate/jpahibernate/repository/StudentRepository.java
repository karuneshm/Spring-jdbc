package com.karunesh.jpa.hibernate.jpahibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Passport;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Student;

@Repository
@Transactional
public class StudentRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}
	
	public void deleteById(Long id) {
		Student student = findById(id);
		entityManager.remove(student);
	}
	
	public Student save(Student student) {
		if(student.getId() == null) {
			entityManager.persist(student);
		} else {
			entityManager.merge(student);
		}
		return student;
	}
	
	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123546");
		entityManager.persist(passport);
		Student student = new Student("Mike");
		student.setPassport(passport);
		entityManager.persist(student);
		
	}
	
	public void insertStudentAndCourse() {
		Student student = new Student("jack");
		Course course = new Course("MicroServices in 100 Steps");
		entityManager.persist(student);
		entityManager.persist(course);
		student.addCourse(course);
		course.addStudent(student);
		entityManager.persist(student);

	}
	
	public void insertStudentAndCourseGeneralized(Student student, Course course) {
		student.addCourse(course);
		course.addStudent(student);
		entityManager.persist(student);
		entityManager.persist(course);
		
	}
	
	

}
