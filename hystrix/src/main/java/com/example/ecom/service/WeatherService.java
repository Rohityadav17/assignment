package com.example.ecom.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
import com.example.ecom.pojo.WeatherData;


@Service
public class WeatherService {

	//@Autowired
   // private RestTemplate restTemplate;
	
	  @Value("${weather.service.api-key}")
	    private String apiKey;

	@Autowired
	FeignClientService feignService;
	
	public List<WeatherData> getWeatherForecastFor30Days( String city) {
		System.out.println("INSIDE SERVICE");
		List<WeatherData> forecast = feignService.getWeatherForecast(city).getList();
		//List<WeatherData> forecast = feignService.getWeatherForecast(city,apiKey).getList();
		if (forecast != null) {
			System.out.println("Service Executed");
            return forecast;
        }
		System.out.println("Service Executed");

        return Collections.emptyList();
	}
	
	
}
/*
    @Value("${weather.service.api-key}")
    private String apiKey;


    public List<WeatherData> getWeatherForecastFor30Days( String city) { 
    	//String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city  + "&appid=" + apiKey;
    	List<WeatherData> forecast = feignService.getWeatherForecast(city,apiKey).getList();

        if (forecast != null) {
            return forecast;
        }

        return Collections.emptyList();
    }
    
    */




