package com.hospital.doctorservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorServiceApplication
{
	//From Spring cloud 6 onwards we don't need to mark our main class with @EnableEurekaClient annotation.
	//We just need to add the eureka client dependency in our pom.xml file.
	public static void main(String[] args) {
		SpringApplication.run(DoctorServiceApplication.class, args);
	}

}
