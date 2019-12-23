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

@SpringBootApplication
public class DatabaseDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonJDBCDao dao;

	public static void main(String[] args) {
		SpringApplication.run(DatabaseDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All users ->{}", dao.findAll());
		logger.info("user Id 10001 ->{}", dao.findById(10001));
		logger.info("users with Location Bangalore ->{}", dao.findByLocation("Bangalore"));
		logger.info("Delete Id 10002 -> No of rows delete - {}", dao.deleteById(10002));
		logger.info("Delete Id 10004 and with location Bangalore -> No of rows delete - {}",
				dao.deleteByIdAndLocation(10004, "Bangalore"));
		logger.info("inserting the person 10100  ----{}", dao.insert(new Person(10100,"Lokesh","Bangalore",new Date())));
		logger.info("updating 10001  ----{}", dao.update(new Person(10001,"Karunesh","London",new Date())));
		

	}

}
