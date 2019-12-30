package com.karunesh.jpa.hibernate.jpahibernate.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	public void jpql_Basic() {
		Query courses = em.createQuery("select c from Course c");
		logger.info("Select c from Course c -> {}", courses.getResultList());
		
	}
	
	@Test
	public void jpql_Typed() {
		TypedQuery<Course> courses = em.createQuery("select c from Course c", Course.class);
		logger.info("Select c from Course c -> {}", courses.getResultList());
		
	}
	
	@Test
	public void jpql_where() {
		TypedQuery<Course> courses = em.createQuery("select c from Course c where name like '%100 steps'", Course.class);
		logger.info("Select c from Course c -> {}", courses.getResultList());
		
	}
	
	@Test
	public void jpql_courses_without_student() {
		TypedQuery<Course> courses = em.createQuery("select c from Course c where c.students is empty", Course.class);
		logger.info("Results -> {}", courses.getResultList());
		
	}
	
	@Test
	public void jpql_courses_with_atleast_2_student() {
		TypedQuery<Course> courses = em.createQuery("select c from Course c where size(c.students) > 2", Course.class);
		logger.info("Results -> {}", courses.getResultList());
		
	}
	
	@Test
	public void jpql_courses_ordered_by_aesc() {
		TypedQuery<Course> courses = em.createQuery("select c from Course c order by size(c.students)", Course.class);
		logger.info("Results -> {}", courses.getResultList());
		
	}
	
	@Test
	public void jpql_courses_ordered_by_desc() {
		TypedQuery<Course> courses = em.createQuery("select c from Course c order by size(c.students) desc", Course.class);
		logger.info("Results -> {}", courses.getResultList());
		
	}
	
	@Test
	public void jpql_students_passports_in_a_certain_order() {
		TypedQuery<Student> studnes = em.createQuery("select s from Student s where s.passport.number like '%1234", Student.class);
		logger.info("Results -> {}", studnes.getResultList());
		
	}
	
	@Test
	public void join() {
		Query query = em.createQuery("Select c,s from Course c JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results size -> {}", resultList.size());
		for(Object[] result : resultList) {
			logger.info("Course {} studensts {} ", result[0], result[1]);
			
		}
		
	}
	
	@Test
	public void left_join() {
		Query query = em.createQuery("Select c,s from Course c LEFT JOIN c.students s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results size -> {}", resultList.size());
		for(Object[] result : resultList) {
			logger.info("Course {} studensts {} ", result[0], result[1]);
			
		}
		
	}
	
	@Test
	public void cross_join() {
		Query query = em.createQuery("Select c,s from Course c, Student s");
		List<Object[]> resultList = query.getResultList();
		logger.info("Results size -> {}", resultList.size());
		for(Object[] result : resultList) {
			logger.info("Course {} studensts {} ", result[0], result[1]);
			
		}
		
	}
	
	

	
}
