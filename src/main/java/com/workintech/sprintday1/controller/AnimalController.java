package com.workintech.sprintday1.controller;

import com.workintech.sprintday1.dto.AnimalResponse;
import com.workintech.sprintday1.entity.Animal;
import com.workintech.sprintday1.validation.AnimalValidControl;
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

    /**   İLK VALIDATION CHECK im:
    public Animal find(@PathVariable int id){
        // ADD ID VALIDATION
        if(!AnimalValidControl.isAnimalIdValid(id)){
            System.out.println("This ID < 0  !!!");
            return null;
        } else {
        return animals.get(id);
        }
    }
     */
    /**
     * Postman de geri dönüş değerimi anlamlandırmak için class açıp verilerimi gizledim. İstediğim değerleri açtım. AnimalResponse class 'ıyla geri dönüş verileri filtrelendi.
     */

    public AnimalResponse find(@PathVariable int id){
        // ADD ID VALIDATION
        if(!AnimalValidControl.isAnimalIdValid(id)){
            return new AnimalResponse(null,"Animal id is not valid: " + id,400);
        }
        if(!AnimalValidControl.isAnimalContains(animals,id)){
            return new AnimalResponse(null,"Animal with given id is not exist: " + id,400);
        }
        return new AnimalResponse(animals.get(id).getName(),"Success", 200);
    }

    @PostMapping("/")
    public Animal save(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
        return animals.get(animal.getId()); // put edilmiş veriyi geri döndürüyorum bana.
        // return animal; da olurdu. direkt post yaptığım veriyi okuyabilmek için böyle yazdım. put çalışmasa bile bana girdiğim parametreyi kaydedemeden döndürebilir. bu yüzden kayıt kontrolü şart. response 'un 200 olması şart aslında.
    }

    @PutMapping("/{id}")
    public Animal update(@PathVariable int id, @RequestBody Animal animal){
        animals.put(id,animal);
        // animals.put(id,new Animal(id, animal.getName(), animal.getWeight()));  // (Alternative)
        return animals.get(id);
    }

    @DeleteMapping("/{id}")
    public Animal delete (@PathVariable int id){
        System.out.println(animals.get(id).getName() + " silindi !");
        return animals.remove(id);  // sildirdiğim id 'yi döndürüyorum.
    }
}
/**
 * Mock Post Data Ex:
    {
            "id": 1,
            "name": "smellyCat",
            "weight": 4.0
            },
            {
            "id": 3,
            "name": "thinCat",
            "weight": 7.0
            },
            {
            "id": 5,
            "name": "pisCat",
            "weight": 8.0
            },
            {
             "id": 8,
             "name": "softCat",
             "weight": 11.0
            }
 */