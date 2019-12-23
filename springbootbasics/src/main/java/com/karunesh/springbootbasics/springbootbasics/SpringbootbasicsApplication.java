package com.karunesh.springbootbasics.springbootbasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringbootbasicsApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringbootbasicsApplication.class, args);
		for(String name:applicationContext.getBeanDefinitionNames())
		{
			System.out.println(name);
		}
	}

}
