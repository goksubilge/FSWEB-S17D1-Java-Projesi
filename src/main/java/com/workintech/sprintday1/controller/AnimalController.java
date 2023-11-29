package com.workintech.sprintday1.controller;

import com.workintech.sprintday1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AnimalController {
    private Map<Integer, Animal> animals;
    @PostConstruct
    public void init(){
        animals = new HashMap<>();
    }

}
