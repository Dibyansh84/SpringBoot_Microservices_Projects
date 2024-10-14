package com.hospital.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
public class ApiGatewayApplication {

	//No need to annotate the main class with @EnableEurekaClient annotation.It is enough to add the spring-cloud-starter-netflix-eureka-client dependency to pom.xml.
	//It is deprecated from Spring cloud 2022.
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}

//#Note:- API gateway will route requests to the appropriate microservices.
