package com.weather.weatherwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.weather.weatherwebservice.entity.WeatherData;
import com.weather.weatherwebservice.service.WeatherService;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/info")
    public WeatherData getWeather(@RequestParam("city") String city) {
        WeatherData weatherData = weatherService.getWeatherData(city);
        return weatherData; 
    }
}
