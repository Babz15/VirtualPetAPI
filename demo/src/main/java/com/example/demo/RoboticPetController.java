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
class RoboticPetController {

    private final RoboticPetRepository repository;

    RoboticPetController(RoboticPetRepository repository) {
        this.repository = repository;
    }


  // Aggregate root
  // tag::get-aggregate-root[]
    @GetMapping("/robotic pets")
    List<RoboticPet> all() {
    return repository.findAll();
    }
  // end::get-aggregate-root[]

    @PostMapping("/roboticpets")
    RoboticPet newRoboticPet(@RequestBody RoboticPet newRoboticPet) {
        return repository.save(newRoboticPet);
    }

  // Single item

    @GetMapping("/roboticpets/{id}")
    RoboticPet one(@PathVariable Long id) {
    
        return repository.findById(id)
        .orElseThrow(() -> new RuntimeException());
}

    @PutMapping("/roboticpets/{id}")
    RoboticPet replaceRoboticPet(@RequestBody RoboticPet newRoboticPet, @PathVariable Long id) {
    
    return repository.findById(id)
        .map(roboticPet -> {
        roboticPet.setName(newRoboticPet.getName());
        roboticPet.setDescription(newRoboticPet.getDescription());
        return repository.save(roboticPet);
        })
        .orElseGet(() -> {
        newRoboticPet.setId(id);
        return repository.save(newRoboticPet);
        });
    }

    @DeleteMapping("/roboticpet/{id}")
    void deleteRoboticPet(@PathVariable Long id) {
    repository.deleteById(id);
    }
}
