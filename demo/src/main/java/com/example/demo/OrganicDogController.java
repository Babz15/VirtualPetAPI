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
class OrganicDogController {

    private final OrganicDogRepository repository;

    OrganicDogController(OrganicDogRepository repository) {
        this.repository = repository;
    }


  // Aggregate root
  // tag::get-aggregate-root[]
    @GetMapping("/organic dogs")
    List<OrganicDog> all() {
    return repository.findAll();
    }
  // end::get-aggregate-root[]

    @PostMapping("/organic dogs")
    OrganicDog newOrganicDog(@RequestBody OrganicDog newOrganicDog) {
        return repository.save(newOrganicDog);
    }

  // Single item

    @GetMapping("/organic dogs/{id}")
    OrganicDog one(@PathVariable Long id) {
    
    return repository.findById(id)
        .orElseThrow(() -> new OrganicDogNotFoundException(id));
    }

    @PutMapping("/organic pets/{id}")
    OrganicDog replaceOrganicDog(@RequestBody OrganicDog newOrganicDog, @PathVariable Long id) {
    
    return repository.findById(id)
        .map(organicDog -> {
        organicDog.setName(newOrganicDog.getName());
        organicDog.setDescription(newOrganicDog.getDescription());
        return repository.save(organicDog);
        })
        .orElseGet(() -> {
        newOrganicDog.setId(id);
        return repository.save(newOrganicDog);
        });
    }

    @DeleteMapping("/organic dog/{id}")
    void deleteOrganicDog(@PathVariable Long id) {
    repository.deleteById(id);
    }
}