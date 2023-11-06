package com.weather.weatherwebservice.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weather.weatherwebservice.pojo.WeatherResponse;

@FeignClient(name = "openweather", url = "https://api.openweathermap.org/data/2.5")
public interface FeignClientService {
	
	 
	// List<WeatherData> getWeatherData(@RequestParam String city,@RequestParam("appid") String apiKey);
	
	
   //WeatherResponse getWeatherForecast(@RequestParam("city") String city);
   
   @GetMapping("/forecast?q={city}&appid={apiKey}")
	WeatherResponse getWeatherForecast( @RequestParam("city") String city,@RequestParam("apiKey") String apiKey);

}


//String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city  + "&appid=" + apiKey;