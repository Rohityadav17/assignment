package com.weather.weatherwebservice.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherwebservice.entity.WeatherData;
import com.weather.weatherwebservice.entity.WeatherForecast;

@Service
public class WeatherService {

    private RestTemplate restTemplate;

    @Value("${openweathermap.apiKey}") // Load the API key from application.properties 
    private String apiKey;


    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    

    public List<WeatherData> getWeatherForecastFor30Days(String city) {
    	String apiUrl = "https://pro.openweathermap.org/data/2.5/forecast/climate?lat=35&lon=139&appid=" + apiKey;
    	//String apiUrl = "https://api.openweathermap.org/data/2.5/forecast/daily?q=" + city  + "&cnt=30&appid=" + apiKey;
    	WeatherForecast forecast = restTemplate.getForObject(apiUrl, WeatherForecast.class);

        if (forecast != null) {
            return forecast.getList();
        }

        return Collections.emptyList();
    }
}

