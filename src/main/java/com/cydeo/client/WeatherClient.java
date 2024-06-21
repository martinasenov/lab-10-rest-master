package com.cydeo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(url = "http://api.weatherstack.com", name = "weatherClient")
public interface WeatherClient {

    @GetMapping("/current")
    Map<String, Object> getWeather(@RequestParam("access_key") String accessKey, @RequestParam("query") String city);

}
