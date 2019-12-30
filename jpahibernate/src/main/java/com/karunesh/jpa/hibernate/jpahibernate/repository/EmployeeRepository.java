package com.karunesh.jpa.hibernate.jpahibernate.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.karunesh.jpa.hibernate.jpahibernate.entity.Course;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Employee;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Passport;
import com.karunesh.jpa.hibernate.jpahibernate.entity.Student;

@Repository
@Transactional
public class EmployeeRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	public void insert(Employee employee) {
		entityManager.persist(employee);
	}
	
	public List<Employee> retriveAllEmployees() {
		return entityManager.createQuery("select e from Employee e", Employee.class).getResultList();
	}
	
	public Student findById(Long id) {
		return entityManager.find(Student.class, id);
	}
	
	

}
