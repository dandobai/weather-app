package com.example.weatherapp.controllers;

import com.example.weatherapp.models.GeoCode;
import com.example.weatherapp.models.WeatherInfo;
import com.example.weatherapp.services.GeocodeService;
import com.example.weatherapp.services.WeatherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class WeatherController {
    @Autowired
    GeocodeService geocodeService;

    @Autowired
    WeatherInfoService weatherInfoService;

    @GetMapping("/geocode:{city}")
    public ResponseEntity<GeoCode> getGeocodeOfCity (@PathVariable String city) throws IOException {
        return ResponseEntity.ok(geocodeService.getGeocode(city));
    }

    @GetMapping("/weather:{city}")
    public ResponseEntity<WeatherInfo> getWeatherInfoOfCity (@PathVariable String city) throws IOException {
        return ResponseEntity.ok(weatherInfoService.getWeatherInfoByGeoCode(geocodeService.getGeocode(city)));
    }
}
