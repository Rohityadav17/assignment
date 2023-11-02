package com.example.ecom.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.ecom.dao.ProductDaoImpl;

@Configuration
public class WithoutXml {
	@Bean
    public ProductDaoImpl productDao() {
        return new AnnotationConfigApplicationContext(JdbcConfig.class)
                .getBean("productdaoimpl", ProductDaoImpl.class);
    }

}
