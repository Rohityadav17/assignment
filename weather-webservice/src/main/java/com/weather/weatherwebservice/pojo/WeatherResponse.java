package com.weather.weatherwebservice.pojo;

import java.util.List;

public class WeatherResponse {
    private List<WeatherData> list;

    public List<WeatherData> getList() {
        return list;
    }

    public void setList(List<WeatherData> list) {
        this.list = list;
    }
}