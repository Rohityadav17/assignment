package com.example.ecom.configuration;

import javax.sql.DataSource;

//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.example.ecom.dao.ProductDao;
import com.example.ecom.dao.ProductDaoImpl;

@Configuration
public class JdbcConfig {
	
	/*
	@Bean
    public ProductDaoImpl productDao() {
        return new ClassPathXmlApplicationContext("com/example/ecom/configuration/config.jdbc.xml")
                .getBean("productdaoimpl", ProductDaoImpl.class);
    }   */
	
	

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/vois");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(getDataSource());
		return jdbcTemplate;
	}

	@Bean("productdaoimpl")
	public ProductDao productDao(JdbcTemplate jdbcTemplate) {
		ProductDaoImpl productDao = new ProductDaoImpl();
		productDao.setJdbcTemplate(getTemplate());
		return productDao;
	}

}
