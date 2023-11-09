package com.example.select_lunch.controller;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@AllArgsConstructor
@RequestMapping("/")
@Slf4j
public class LunchController {

    private final Environment env;
    private final RestTemplate restTemplate;
    
    @GetMapping("/test")
    public String test() {
        log.error("tttttttttttt");
        return "test  OKasdfafd";
    }


    @GetMapping("/search/{search}")
    public String search(@PathVariable String search) {

        log.error("test");

        String baseUrl = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json";
        String uri = UriComponentsBuilder.fromHttpUrl(baseUrl)
                .queryParam("input", search)
                .queryParam("inputtype", "textquery")
                .queryParam("fields", "formatted_address,name,rating,opening_hours,geometry")
                .queryParam("key", env.getProperty("google.places.api_key"))
                .encode()
                .toUriString();

        return restTemplate.getForObject(uri, String.class);

    }
}
