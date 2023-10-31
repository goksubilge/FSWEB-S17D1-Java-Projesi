package com.workintech.sprintday1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hi")
public String sayHi(){
        return "Say Hello to the Girl Who I am !!!";
    }
}
