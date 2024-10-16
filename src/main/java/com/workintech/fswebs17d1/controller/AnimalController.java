package com.workintech.fswebs17d1.controller;


import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    Map<Integer, Animal> animals = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals(){
        System.out.println("girdi.");
        return ResponseEntity.ok(new ArrayList<>(animals.values()));
    }

    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id){
        return animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal){
        animals.put(animal.getId(),animal);
    }

    @PutMapping("/{id}")
    public void modifyAnimal(@PathVariable Integer id,@RequestBody Animal animal){
        if(animals.containsKey(id)){
            animals.put(id,animal);
            System.out.println("Güncellendi");
        }else System.out.println("Hayvan bulunamadı.");
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id){
        if(animals.containsKey(id)){
            animals.remove(id);
            System.out.println("Silindi");
        }else System.out.println("Hayvan bulunamadı.");
    }
}
