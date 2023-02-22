package com.example.weatherapp.services;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.weatherapp.models.GeoCode;
import org.springframework.stereotype.Service;

@Service
public class GeocodeServiceImp implements GeocodeService {
    @Override
    public GeoCode getGeocode(String city) throws IOException {
        String lowerCasedCity = "london";
        URL url = new URL("https://api.api-ninjas.com/v1/geocoding?city=" + lowerCasedCity);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("x-api-key", System.getenv("API-KEY"));
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseStream);
        GeoCode[] geoCode = mapper.convertValue(root,GeoCode[].class);
        return geoCode[0];
    }
}
