package com.karunesh.database.databasedemo;

import java.sql.Timestamp;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.karunesh.database.databasedemo.entity.Person;
import com.karunesh.database.databasedemo.jdbc.PersonJDBCDao;
import com.karunesh.database.databasedemo.jpa.PersonJpaRepository;

@SpringBootApplication
public class JpaDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(JpaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		logger.info("user Id 10001 ->{}", repository.findById(10001));
		logger.info("All users ->{}", repository.findAll());
		//logger.info("users with Location Bangalore ->{}", repository.findByLocation("Bangalore"));
		repository.deleteById(10003);
		//logger.info("Delete Id 10004 and with location Bangalore -> No of rows delete - {}",
		//		repository.deleteByIdAndLocation(10004, "Bangalore"));
		logger.info("inserting the   ----{}", repository.insert(new Person("Lokesh","Bangalore",new Date())));
		logger.info("updating 10001  ----{}", repository.update(new Person(10001,"Karunesh","London",new Date())));
		

	}

}
