package com.workintech.sprintday1.validation;
import com.workintech.sprintday1.entity.Animal;
import java.util.Map;

public class AnimalValidControl {
    public static boolean isAnimalIdValid(int id){
        return !(id<0 || id>5);
    }
    public static boolean isAnimalContains(Map<Integer,Animal> animals, int id){
        return animals.containsKey(id);
    }
    public static boolean isAnimalCredentialsValid(Animal animal){
        return !(animal.getId() <= 0||
                animal.getName() == null||
                animal.getName().isEmpty()||
                animal.getWeight() <= 0 );
    }
}