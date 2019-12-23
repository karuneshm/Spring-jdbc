package com.karunesh.database.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.karunesh.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {

	// connect to Database
	@PersistenceContext
	EntityManager entity;
	
	public List<Person> findAll() {
     TypedQuery<Person> namedQuery = entity.createNamedQuery("find_all_person", Person.class);
     return namedQuery.getResultList();

	}

	public Person findById(int id) {
		return entity.find(Person.class, id);
	}
	
	public Person update(Person person) {
		return entity.merge(person);
	}
	
	public Person insert(Person person) {
		return entity.merge(person);
	}
	
	public void deleteById(int id) {
		Person person = entity.find(Person.class, id);
		entity.remove(person);
	} 
}
