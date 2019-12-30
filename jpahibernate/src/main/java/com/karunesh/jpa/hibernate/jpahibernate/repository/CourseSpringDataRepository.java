package com.karunesh.jpa.hibernate.jpahibernate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;

@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {
	
	List<Course> findByName(String name);
	List<Course> countByName(String name);
	List<Course> deleteByName(String name);
	

	@Query("Select c from Course c")
	List<Course> courseAll();
}
