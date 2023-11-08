package com.example.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecom.pojo.WeatherData;
import com.example.ecom.service.WeatherService;

@RestController
@RequestMapping("/weather")
@CrossOrigin
public class WeatherController {

	@Autowired
    private  WeatherService weatherService;

   

    @GetMapping("/getWeather")
    public List<WeatherData> getWeather(@RequestParam String city){
    System.out.println("Inside Controller");
        List<WeatherData> weatherData = weatherService.getWeatherForecastFor30Days(city);
        return weatherData; 
    }
}
