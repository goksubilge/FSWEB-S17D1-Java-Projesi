package com.workintech.sprintday1.controller;

import com.workintech.sprintday1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;
    @PostConstruct  // Constructor çalıştıktan sonra yalnızca tek bir defa constructor çalıştırma komutudur.
    public void init(){
        System.out.println("Animal Map Created: (second rendered part: bcs of:Post construct)");
        animals = new HashMap<>();
    }
    public AnimalController(){
        System.out.println("Animal Created: ( first rendered part)");
    }

    @GetMapping("/")  // tüm animals 'ı çağırdığım liste. şimdilik boş array []
public List<Animal> findAll(){
        System.out.println("Get All Animals (@getMapping 'e adres verdiğim anda render olur bu method)");
        return animals.values().stream().toList();
    }
    @GetMapping("/{id}")  //  id ile (ilgili id map'te varsa) value 'nun değerini döner.
    public Animal find(@PathVariable int id){
        return animals.get(id);
    }

    @PostMapping("/")
    public Animal save(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return animals.get(animal.getId()); // put edilmiş veriyi geri döndürüyorum bana.
        // return animal; da olurdu. direkt post yaptığım veriyi okuyabilmek için böyle yazdım. put çalışmasa bile bana girdiğim parametreyi kaydedemeden döndürebilir. bu yüzden kayıt kontrolü şart. response 'un 200 olması şart aslında.
    }
}
