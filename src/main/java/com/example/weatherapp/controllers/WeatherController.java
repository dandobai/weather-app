package com.example.weatherapp.controllers;

import com.example.weatherapp.models.GeoCode;
import com.example.weatherapp.services.GeocodeService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@RestController
public class WeatherController {
    @Autowired
    GeocodeService geocodeService;
    @GetMapping("/")
    public ResponseEntity<GeoCode> getGeocodeOfCity (String city) throws IOException {
        return ResponseEntity.ok(geocodeService.getGeocode(city));
    }
}
