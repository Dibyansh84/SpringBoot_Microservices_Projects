package com.zomato.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication
{
	//From Spring cloud 6 onwards we don't need to mark our main class with @EnableEurekaClient annotation explicitly.
	//We just need to add the eureka client dependency in our pom.xml file.
	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
