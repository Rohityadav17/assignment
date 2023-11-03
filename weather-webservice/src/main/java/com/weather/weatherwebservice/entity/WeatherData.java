package com.weather.weatherwebservice.entity;

import java.util.List;

public class WeatherData {
    private Temperature temp;
    private int pressure;
    private int humidity;
    private List<WeatherInfo> weather;

    public Temperature getTemp() {
        return temp;
    }

    public void setTemp(Temperature temp) {
        this.temp = temp;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public List<WeatherInfo> getWeather() {
        return weather;
    }

    public void setWeather(List<WeatherInfo> weather) {
        this.weather = weather;
    }
}
