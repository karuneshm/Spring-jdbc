package com.karunesh.jpa.hibernate.jpahibernate.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpa.hibernate.jpahibernate.JpahibernateApplication;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Review;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpahibernateApplication.class)
class CourseRepositoryDataRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseSpringDataRepository repository;
	
	@Test
	public void findById() {
		Optional<Course> courseOptional = repository.findById(10001l);
		assertTrue(courseOptional.isPresent());
	}
	
	@Test
	public void findById_courseNotPresent() {
		Optional<Course> courseOptional = repository.findById(20001l);
		assertFalse(courseOptional.isPresent());
		
	}
	
	@Test
	public void playingAroundWithSpringDataJPA() {
		/*Course course = new Course("MicroServices in 100 Steps");
		repository.save(course);
		course.setName("MicfoServices in 50 Steps");
		repository.save(course);*/
		
		/*
		  logger.info("{}",repository.findAll()); logger.info("{}",repository.count());
		 */
		
		
		
	}
	
	@Test
	public void sort() {
		/*Course course = new Course("MicroServices in 100 Steps");
		repository.save(course);
		course.setName("MicfoServices in 50 Steps");
		repository.save(course);*/
		
       	
		//Sort sort = new Sort(Sort.Direction.DESC, "name");
		logger.info("{}",repository.findAll()); 
		
		
		logger.info("{}",repository.count());
	}
	
	@Test
	public void pagination() {
		/*Course course = new Course("MicroServices in 100 Steps");
		repository.save(course);
		course.setName("MicfoServices in 50 Steps");
		repository.save(course);*/
		
       	
		//Sort sort = new Sort(Sort.Direction.DESC, "name");
		PageRequest pageRequest = PageRequest.of(0,3);
		Page<Course> firstPage = repository.findAll(pageRequest);
		logger.info("{}",firstPage.getContent()); 
		
		
		logger.info("{}",repository.count());
	}
	
	@Test
	public void findByName() {
	
		logger.info("Find By Name - >{}",repository.findByName("SpringBoot"));
	}
}
