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
public class Passport {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable= false)
	private String number;
	
	@OneToOne(fetch=FetchType.LAZY, mappedBy="passport")
	private Student student;
	
	public Passport() {
		
	}
	
	

	public Passport(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	

	public Student getStudent() {
		return student;
	}



	public void setStudent(Student student) {
		this.student = student;
	}



	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Paasport [id=" + id + ", number=" + number + "]";
	}
	
	
	
	
	

}
