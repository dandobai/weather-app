package com.example.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    @JsonProperty("main")
    String main;
    @JsonProperty("description")
    String description;

    public Weather() {
    }

    public Weather(String main, String description) {
        this.main = main;
        this.description = description;
    }

}
