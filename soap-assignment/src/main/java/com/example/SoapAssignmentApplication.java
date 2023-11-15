package com.example;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.example.client.wsimport.NumberConversion;
import com.example.client.wsimport.NumberConversionSoapType;

@SpringBootApplication
public class SoapAssignmentApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoapAssignmentApplication.class, args);
    }
	
    @Bean
    public NumberConversionSoapType numberConversionSoapType() {
        NumberConversion numberConversion = new NumberConversion();
        return numberConversion.getNumberConversionSoap();
    }
    
    
    
 
}


