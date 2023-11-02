package com.weather.weatherwebservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherData {
    @JsonProperty("name")   // JSON field with the name "name" should be mapped to the city property in the Java class.
    private String city;
    @JsonProperty("main")    //JSON field with the name "main" should be mapped to the weatherInfo property in the Java class.
    private WeatherInfo weatherInfo;

    public String getCity() {
        return city;
    }

    public WeatherInfo getWeatherInfo() {
        return weatherInfo;
    }
}

