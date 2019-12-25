package com.karunesh.jpa.hibernate.jpahibernate.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
public class Student {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable= false)
	private String name;
	
	@OneToOne(fetch=FetchType.LAZY)
	private Passport passport;
	
	
	public Student() {
		
	}
	
	

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	

	public Passport getPassport() {
		return passport;
	}



	public void setPassport(Passport passport) {
		this.passport = passport;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
	
	
	
	
	

}
