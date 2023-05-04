package com.udemy.springboot.demo.springudemy.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${jo.mateix}")
    private String name;

    @GetMapping("/")
    public String sayHello() {
        return  "Hello " + name;
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "workout";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "lucky!";
    }
}
