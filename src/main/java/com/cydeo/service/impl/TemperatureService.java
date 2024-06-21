package com.cydeo.service.impl;

import com.cydeo.client.WeatherClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TemperatureService {


    private static final String ACCESS_KEY = "261921343fc50cef2e90b2306f9173ed";

    private final WeatherClient weatherClient;


    public TemperatureService(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    public Integer getTemperature(String city) {
        Map<String, Object> response = weatherClient.getWeather(ACCESS_KEY, city);

        Map<String, Object> current = (Map<String, Object>) response.get("current");
        return (Integer) current.get("temperature");
    }
}
