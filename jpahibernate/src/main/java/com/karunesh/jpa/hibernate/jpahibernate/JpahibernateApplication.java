package com.karunesh.jpa.hibernate.jpahibernate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;
import com.karunesh.jpa.hibernate.jpahibernate.repository.CourseRepository;

@SpringBootApplication
public class JpahibernateApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpahibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Course course = repository.findById(10001L);
		logger.info(" Course 10001 ->{} ",course);
		repository.save(new Course("MicroServices"));
		repository.save(new Course("Java"));
	}

}
