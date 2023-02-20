package com.example.weatherapp.services;

import com.example.weatherapp.models.GeoCode;

import java.io.IOException;
import java.net.MalformedURLException;

public interface GeocodeService {
    GeoCode getGeocode(String city) throws IOException;
}
