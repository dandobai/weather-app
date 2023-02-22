package com.example.weatherapp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)

public class Main {
    @JsonProperty("temp")
    String temp;

    public Main() {
    }

    public Main(String temp) {
        this.temp = temp;
    }
}
