package com.example.ecom.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.ecom.pojo.WeatherData;
import com.example.ecom.pojo.WeatherResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class WeatherFallback implements FeignClientService{
	
	 @Value("${weather.service.api-key}")
	  private String apiKey;
	 
/*
	   public List<WeatherData> getWeatherForecastFor30Days( String city) { 
		System.out.println("Fallback Method Executed");
    	String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city  + "&appid=" + apiKey;
    	List<WeatherData> forecast = restTemp.getForObject(apiUrl,WeatherResponse.class).getList();

        if (forecast != null) {
            return forecast;
        }

        return Collections.emptyList();
    }
    
   */

	@Override
	@HystrixCommand(fallbackMethod = "getWeatherForecast")
	public WeatherResponse getWeatherForecast(String city) {
		// TODO Auto-generated method stub
		System.out.println("RestTemplate Server is down");
		return null;
	}

}
