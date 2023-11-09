package com.example.select_lunch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LunchController {
    
    @GetMapping("/test")
    public String test() {
        return "test  OK";
    }
}
