package com.example.weatherapp.services;

import com.example.weatherapp.models.GeoCode;
import com.example.weatherapp.models.WeatherInfo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class WeatherInfoServiceImp implements WeatherInfoService {
    @Override
    public WeatherInfo getWeatherInfoByGeoCode(GeoCode geoCode) throws IOException {
        String lat = "" + geoCode.latitude();
        String lon = "" + geoCode.longitude();
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat="
                + lat
                + "&lon="
                + lon
                + "&appid="
                + System.getenv("API KEY"));
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("x-api-key", System.getenv("API KEY"));
        InputStream responseStream = connection.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(responseStream);
        return mapper.convertValue(root, WeatherInfo.class);
    }
}
