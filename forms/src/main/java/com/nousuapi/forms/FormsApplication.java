package com.nousuapi.forms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nousuapi.forms.configuration.ConfigurationContext;

@SpringBootApplication
public class FormsApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FormsApplication.class, args);
	}
}

