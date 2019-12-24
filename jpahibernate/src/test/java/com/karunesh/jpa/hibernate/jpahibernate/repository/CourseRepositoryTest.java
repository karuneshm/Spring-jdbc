package com.karunesh.jpa.hibernate.jpahibernate.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.karunesh.jpa.hibernate.jpahibernate.JpahibernateApplication;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpahibernateApplication.class)
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;

	@Test
	public void findById_Basic() {
		Course c = repository.findById(10001L);
		assertEquals("Jpa And Hibernate",c.getName());	
	}
	
	@Test
	@DirtiesContext
	public void deleteByID_Basic() {
		repository.deleteById(10002L);
		assertNull(repository.findById(10002L));	
	}
	
	@Test
	public void Save_Basic() {
		Course course = repository.findById(10001L);
		assertEquals("Jpa And Hibernate",course.getName());
		course.setName("Jpa And Hibernate updated");
		repository.save(course);
		Course course1 = repository.findById(10001L);
		assertEquals("Jpa And Hibernate updated",course1.getName());	
	}

	
}
