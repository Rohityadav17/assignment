package com.weather.weatherwebservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weather.weatherwebservice.entity.WeatherData;

@Service
public class WeatherService {

    private RestTemplate restTemplate;

    @Value("${openweathermap.apiKey}") // Load the API key from application.properties 
    private String apiKey;

    @Autowired
    public WeatherService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherData getWeatherData(String city) {
        String apiUrl ="https://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + apiKey;
        return restTemplate.getForObject(apiUrl, WeatherData.class);
    }
}

