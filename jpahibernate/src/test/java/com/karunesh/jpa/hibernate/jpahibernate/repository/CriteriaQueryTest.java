package com.karunesh.jpa.hibernate.jpahibernate.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
import com.karunesh.jpa.hibernate.jpahibernate.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpahibernateApplication.class)
class CriteriaQueryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	public void criteria_basic() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Query courses = em.createQuery(cq.select(courseRoot));
		logger.info("Courses -> {}", courses.getResultList());
		
	}
	
	@Test
	public void criteria_courses_having_100_Steps() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Predicate like100steps = cb.like(courseRoot.get("name"), "%100 steps");
		cq.where(like100steps);
		Query courses = em.createQuery(cq.select(courseRoot));
		logger.info("Courses -> {}", courses.getResultList());
		
	}
	
	@Test
	public void criteria_all_courses_without_students() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Predicate isempty = cb.isEmpty(courseRoot.get("students"));
		cq.where(isempty);
		Query courses = em.createQuery(cq.select(courseRoot));
		logger.info("Courses -> {}", courses.getResultList());
		
	}
	
	@Test
	public void criteria_Join() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Join<Object, Object> join = courseRoot.join("students");
		Query courses = em.createQuery(cq.select(courseRoot));
		logger.info("Courses -> {}", courses.getResultList());
		
	}
	
	@Test
	public void criteria_left_Join() {
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course> courseRoot = cq.from(Course.class);
		Join<Object, Object> join = courseRoot.join("students",JoinType.LEFT);
		Query courses = em.createQuery(cq.select(courseRoot));
		logger.info("Courses -> {}", courses.getResultList());
		
	}
	
	

	
}
