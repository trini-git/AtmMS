package com.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AtmMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmMsApplication.class, args);
	}

}
