package com.karunesh.jpa.hibernate.jpahibernate.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
	

	
}
