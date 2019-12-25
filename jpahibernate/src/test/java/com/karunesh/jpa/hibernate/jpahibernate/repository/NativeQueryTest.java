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
class NativeQueryTest {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	@Test
	public void native_queries_Basic() {
		Query courses = em.createNativeQuery("Select * from course", Course.class);
		logger.info("Select c from Course c -> {}", courses.getResultList());
		
	}
	
	@Test
	public void native_queries_with_Parameters() {
		Query courses = em.createNativeQuery("Select * from course where id = ?", Course.class);
		 courses.setParameter(1, 10001L);
		logger.info("Select * from course where id = 10001L", courses.getResultList());
		
	}
	
	@Test
	public void native_queries_with_names_Parameters() {
		Query courses = em.createNativeQuery("Select * from course where id = :id", Course.class);
		 courses.setParameter("id", 10001L);
		logger.info("Select * from course where id = 10001L", courses.getResultList());
		
	}
	
	
	
	

	
}
