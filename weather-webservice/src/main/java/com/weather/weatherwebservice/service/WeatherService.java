package com.weather.weatherwebservice.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;

import com.weather.weatherwebservice.feignclient.FeignClientService;
import com.weather.weatherwebservice.pojo.WeatherData;
//import com.weather.weatherwebservice.pojo.WeatherResponse;

@Service
public class WeatherService {

	//@Autowired
   // private RestTemplate restTemplate;

	@Autowired
	FeignClientService feignService;
	
    private String apiKey="9953bc589043b17428907f390aebd07f";



    public List<WeatherData> getWeatherForecastFor30Days(String city) { 
    	//String apiUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + city  + "&appid=" + apiKey;
    	List<WeatherData> forecast = feignService.getWeatherForecast(city,apiKey).getList();

        if (forecast != null) {
            return forecast;
        }

        return Collections.emptyList();
    }
}

