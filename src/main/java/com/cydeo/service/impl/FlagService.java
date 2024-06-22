package com.cydeo.service.impl;

import com.cydeo.client.CountryClient;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FlagService {

    private final CountryClient countryClient;

    public FlagService(CountryClient countryClient) {
        this.countryClient = countryClient;
    }

    public String getFlag(String country){
        List<Map<String, Object>> response = countryClient.getFlag(country);

        if (!response.isEmpty()) {
            Map<String, Object> countryInfo = response.get(0); // Get the first element in the list
            Map<String, Object> flags = (Map<String, Object>) countryInfo.get("flags");
            return (String) flags.get("png");
        }

        throw new RuntimeException("Flag not found for country: " + country);
    }
}
