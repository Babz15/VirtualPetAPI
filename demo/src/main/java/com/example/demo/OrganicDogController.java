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
    @GetMapping("/organicdogs")
    List<OrganicDog> all() {
    return repository.findAll();
    }
  // end::get-aggregate-root[]

    @PostMapping("/organicdogs")
    OrganicDog newOrganicDog(@RequestBody OrganicDog newOrganicDog) {
        return repository.save(newOrganicDog);
    }

  // Single item

    @GetMapping("/organicdogs/{id}")
    OrganicDog one(@PathVariable Long id) {
    
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/organicdogs/{id}")
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

    @DeleteMapping("/organicdog/{id}")
    void deleteOrganicDog(@PathVariable Long id) {
    repository.deleteById(id);
    }
}