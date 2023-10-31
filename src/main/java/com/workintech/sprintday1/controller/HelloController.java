package com.workintech.sprintday1.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hi")
public String sayHi(){
        name ="Burak "; // app.proporties 'ki tanımlanan bilge'yi baskılar.
        return name + " Say Hello to the Girl Who I am !!!";
    }

     @Value("${instructor.name}")
    private String name;
    @Value("${instructor.surname}")
    private String surname;
}
