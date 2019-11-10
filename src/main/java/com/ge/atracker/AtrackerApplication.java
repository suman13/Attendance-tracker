package com.ge.atracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@SpringBootApplication
@EntityScan( basePackages = {"com.ge.atracker.model"} )
public class AtrackerApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AtrackerApplication.class, args);
	}
}
