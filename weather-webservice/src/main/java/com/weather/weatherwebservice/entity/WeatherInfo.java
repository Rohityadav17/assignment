package com.weather.weatherwebservice.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherInfo {
    @JsonProperty("temp")
    private double temperature;  
    @JsonProperty("temp_min")
    private double minTemperature; 
    @JsonProperty("temp_max")
    private double maxTemperature; 
    @JsonProperty("humidity")
    private int humidity;       

    public double getTemperature() {
        return temperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public int getHumidity() {
        return humidity;
    }
}

