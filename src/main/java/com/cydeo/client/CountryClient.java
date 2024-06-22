package com.cydeo.client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

@FeignClient(url = "https://restcountries.com/v3.1/name",name = "countryClient")
public interface CountryClient {


    @GetMapping("/{country}")
    List<Map<String, Object>> getFlag(@PathVariable("country") String country);


}
