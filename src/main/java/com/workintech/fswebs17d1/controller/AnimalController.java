package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {


    private final Map<Integer, Animal> animals = new HashMap<>();


    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        System.out.println("Tüm hayvanlar listelendi.");
        return ResponseEntity.ok(new ArrayList<>(animals.values()));
    }


    @GetMapping("/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        return animals.get(id);
    }


    @PostMapping
    public ResponseEntity<Animal> addAnimal(@RequestBody Animal animal) {
        if (animals.containsKey(animal.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);
        }
        animals.put(animal.getId(), animal);
        System.out.println("Yeni hayvan eklendi: " + animal);
        return ResponseEntity.status(HttpStatus.OK).body(animal);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Animal> modifyAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        if (animals.containsKey(id)) {
            animals.put(id, animal);
            System.out.println("Hayvan güncellendi: " + animal);
            return ResponseEntity.ok(animal);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable Integer id) {
        animals.remove(id);
    }

}
