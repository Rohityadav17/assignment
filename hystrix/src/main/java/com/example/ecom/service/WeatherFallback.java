package com.example.ecom.service;

import org.springframework.stereotype.Component;

import com.example.ecom.pojo.WeatherResponse;

@Component
public class WeatherFallback implements FeignClientService {
	
	@Override
	public WeatherResponse getWeatherForecast(String city) {
		System.out.println("Fallback Executed");
		return null;
		
	}


}
