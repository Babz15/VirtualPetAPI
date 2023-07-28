package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RoboticDogController {

    private final RoboticDogRepository repository;

    RoboticDogController(RoboticDogRepository repository) {
        this.repository = repository;
    }


  // Aggregate root
  // tag::get-aggregate-root[]
    @GetMapping("/robotic dogs")
    List<RoboticDog> all() {
    return repository.findAll();
    }
  // end::get-aggregate-root[]

    @PostMapping("/robotic dogs")
    RoboticDog newRoboticDog(@RequestBody RoboticDog newRoboticDog) {
        return repository.save(newRoboticDog);
    }

  // Single item

    @GetMapping("/virtual dogs/{id}")
    RoboticDog one(@PathVariable Long id) {
    
    return repository.findById(id)
        .orElseThrow(() -> new RoboticDogNotFoundException(id));
    }

    @PutMapping("/virtual dogs/{id}")
    RoboticDog replaceRoboticDog(@RequestBody RoboticDog newRoboticDog, @PathVariable Long id) {
    
    return repository.findById(id)
        .map(roboticDog -> {
        roboticDog.setName(newRoboticDog.getName());
        roboticDog.setDescription(newRoboticDog.getDescription());
        return repository.save(roboticDog);
        })
        .orElseGet(() -> {
        newRoboticDog.setId(id);
        return repository.save(newRoboticDog);
        });
    }

    @DeleteMapping("/robotic dog/{id}")
    void deleteRoboticDog(@PathVariable Long id) {
    repository.deleteById(id);
    }
}
