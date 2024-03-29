package com.karunesh.jpa.hibernate.jpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Review;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public Course findById(Long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		entityManager.remove(course);
	}
	
	public Course save(Course course) {
		if(course.getId() == null) {
			entityManager.persist(course);
		} else {
			entityManager.merge(course);
		}
		return course;
	}
	
	public void playWithEntityManager() {
        Course course1 = new Course("Rest Web services");
		entityManager.persist(course1);	
		Course course2 = new Course("Angular JS");
		entityManager.persist(course2);	
		entityManager.flush();
		
		
		
		course1.setName("Rest Web Services Updated");
		course2.setName("Anjular JS Updated");
		entityManager.refresh(course1);
		entityManager.flush();
	}
	
	public void addReviewsForCourse() {
		Course course = findById(10003l);
		logger.info("couser getreviews() -> {}",course.getReviews());
		Review review1 = new Review("5","Good Course");
		Review review2 = new Review("5","Hatoff.");
		course.addReview(review1);
		review1.setCourse(course);
		course.addReview(review2);
		review2.setCourse(course);
		entityManager.persist(review1);
		entityManager.persist(review2);
		
			
	}
	
	public void addReviewsForCourse(Long courseId, List<Review> reviews) {
		Course course = findById(courseId);
		logger.info("couser getreviews() -> {}",course.getReviews());
		for(Review review : reviews) {
			course.addReview(review);
			review.setCourse(course);
			entityManager.persist(review);
		}
		
				
	}

}
