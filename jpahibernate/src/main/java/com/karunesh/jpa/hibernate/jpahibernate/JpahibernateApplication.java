package com.karunesh.jpa.hibernate.jpahibernate;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Review;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Student;
import com.karunesh.jpa.hibernate.jpahibernate.repository.CourseRepository;
import com.karunesh.jpa.hibernate.jpahibernate.repository.StudentRepository;

@SpringBootApplication
public class JpahibernateApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpahibernateApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Course course = repository.findById(10001L);
		 * logger.info(" Course 10001 ->{} ",course); repository.save(new
		 * Course("MicroServices")); repository.save(new Course("Java"));
		 * repository.playWithEntityManager();
		 */
		
		//studentRepository.saveStudentWithPassport();
		//courseRepository.addReviewsForCourse();
		//List<Review> reviews = new ArrayList<>();
		//reviews.add(new Review("5","Good Course"));
		//reviews.add(new Review("5","Hatoff."));
		
		//courseRepository.addReviewsForCourse(10003L, reviews);
		//studentRepository.insertStudentAndCourse();
		studentRepository.insertStudentAndCourseGeneralized(new Student("jack"), new Course("MicroServices in 100 Steps"));
	   
		
	}

}
