package com.karunesh.jpa.hibernate.jpahibernate.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
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

}
