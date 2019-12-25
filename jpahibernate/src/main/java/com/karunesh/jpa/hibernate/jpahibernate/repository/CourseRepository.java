package com.karunesh.jpa.hibernate.jpahibernate.repository;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;

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

}
