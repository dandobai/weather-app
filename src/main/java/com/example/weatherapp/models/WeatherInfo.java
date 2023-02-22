package com.example.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

    @JsonProperty("main")
    Main main;

    public WeatherInfo() {
    }

    public WeatherInfo(Weather weather, Main main) {
        this.main = main;
    }
}
