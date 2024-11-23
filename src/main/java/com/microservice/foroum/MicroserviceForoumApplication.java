package com.microservice.foroum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceForoumApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceForoumApplication.class, args);
	}

}
