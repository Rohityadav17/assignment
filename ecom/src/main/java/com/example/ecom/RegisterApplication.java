package com.example.ecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.ecom.configuration.JdbcConfig;
import com.example.ecom.dao.ProductDaoImpl;

@SpringBootApplication
@ComponentScan(basePackages ="com.example.ecom")
public class RegisterApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterApplication.class, args);
	}
	
	@Bean
    public ProductDaoImpl productDao() {
        return new AnnotationConfigApplicationContext(JdbcConfig.class)
                .getBean("productdaoimpl", ProductDaoImpl.class);
    }

}
