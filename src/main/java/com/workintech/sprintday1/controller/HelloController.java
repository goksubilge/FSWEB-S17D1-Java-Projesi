package com.workintech.sprintday1.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HelloController {
    @Value("${instructor.name}")  // application.properties 'ten çekiyor.
    private String name;
    @Value("${instructor.surname}")  // application.properties 'ten çekiyor.
    private String surname;
    @Value("1.2.5")    // manuel veri girişi, aşağıda kullanmadım.
    private String version;

    @GetMapping("/hi")
    public String sayHi(){
        name ="Burak: "; // app.properties 'ki tanımlanan bilge 'yi baskılar.
        return name + " Say Hello to the Girl Who I am !!!";
    }
}
