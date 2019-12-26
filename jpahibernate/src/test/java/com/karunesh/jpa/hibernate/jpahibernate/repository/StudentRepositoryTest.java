package com.karunesh.jpa.hibernate.jpahibernate.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpa.hibernate.jpahibernate.JpahibernateApplication;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Passport;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpahibernateApplication.class)
class StudentRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	StudentRepository repository;
	
	@Autowired
	EntityManager entityManager;

	@Test
	public void findById_Basic() {
		Student c = repository.findById(10001L);
		assertEquals("Jpa And Hibernate",c.getName());	
	}
	
	@Test
	@Transactional
	public void someTest() {
		
		Student student = entityManager.find(Student.class, 20001L);
		Passport passport = student.getPassport();
		passport.setNumber("E123456");
		student.setName("Karunesh");
		
		
	}
	
	@Test
	@Transactional
	public void retriveStudentAndPassportDetails() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info(" studnet -> {}", student);
		logger.info("passport  -> {}", student.getPassport());
	}
	
	@Test
	@Transactional
	public void retrivePassprtAndStudent() {
		Passport passport = entityManager.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("studnet  -> {}", passport.getStudent());
	}
	
	@Test
	@Transactional
	public void retriveStudentAndCourses() {
		Student student =  entityManager.find(Student.class, 20001l);
		logger.info("student -> {}", student);
		logger.info("Courses  -> {}", student.getCourses());
	}

	
}
