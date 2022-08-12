package com.mindtree.Collegeapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class College1Application {

	public static void main(String[] args) {
		SpringApplication.run(College1Application.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate()
	{
		return new RestTemplate();
		
	}

}
