package com.example.ecom.service;


import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ecom.pojo.WeatherData;
import com.example.ecom.pojo.WeatherResponse;

@FeignClient(name = "resttemmplate-feignfallback", url ="${weather.service.base-url}" ,fallback=WeatherFallback.class)
public interface FeignClientService {

	@GetMapping("/getWeather")
	WeatherResponse getWeatherForecast(@RequestParam("city")String city);  
	

}


/*
@GetMapping("/forecast?q={city}&appid={apiKey}")
	WeatherResponse getWeatherForecast( @RequestParam("city") String city,@RequestParam("apiKey") String apiKey);


String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city  + "&appid=" + apiKey;

*/