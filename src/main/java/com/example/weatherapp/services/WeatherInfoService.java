package com.example.weatherapp.services;

import com.example.weatherapp.models.GeoCode;
import com.example.weatherapp.models.WeatherInfo;

import java.io.IOException;
import java.net.MalformedURLException;

public interface WeatherInfoService {
    WeatherInfo getWeatherInfoByGeoCode(GeoCode geoCode) throws IOException;
}
