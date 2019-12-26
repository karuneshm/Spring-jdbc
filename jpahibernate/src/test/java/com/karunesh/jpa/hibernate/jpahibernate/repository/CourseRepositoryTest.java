package com.karunesh.jpa.hibernate.jpahibernate.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpa.hibernate.jpahibernate.JpahibernateApplication;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Review;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpahibernateApplication.class)
class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository repository;
	
	@Autowired
	EntityManager em;

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
	@DirtiesContext
	public void Save_Basic() {
		Course course = repository.findById(10001L);
		assertEquals("Jpa And Hibernate",course.getName());
		course.setName("Jpa And Hibernate updated");
		repository.save(course);
		Course course1 = repository.findById(10001L);
		assertEquals("Jpa And Hibernate updated",course1.getName());	
	}
	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
		
	}
	
	@Test
	@Transactional
	public void retriveReviewsForCourse() {
		Course course = repository.findById(10001L);
		logger.info("{}",course.getReviews());
		
	}
	
	@Test
	@Transactional
	public void retriveCourseForReview() {
		Review review = em.find(Review.class,50001l);
		logger.info("{}",review.getCourse());
		
		
	}
	
	@Test
	@Transactional
	public void retriveCourseAndStudents() {
		Course course =  em.find(Course.class, 10001l);
		logger.info("Course -> {}", course);
		logger.info("Students  -> {}", course.getStudents());
	}


	
}
