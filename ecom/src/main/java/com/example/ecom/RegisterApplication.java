package com.example.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new  RestTemplate();
	}   

}
