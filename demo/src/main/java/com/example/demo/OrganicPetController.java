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
class OrganicPetController {

    private final OrganicPetRepository repository;

    OrganicPetController(OrganicPetRepository repository) {
        this.repository = repository;
    }


  // Aggregate root
  // tag::get-aggregate-root[]
    @GetMapping("/organic pets")
    List<OrganicPet> all() {
    return repository.findAll();
    }
  // end::get-aggregate-root[]

    @PostMapping("/organicpets")
    OrganicPet newOrganicPet(@RequestBody OrganicPet newOrganicPet) {
        return repository.save(newOrganicPet);
    }

  // Single item

    @GetMapping("/organicpets/{id}")
    OrganicPet one(@PathVariable Long id) {
    
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/organicpets/{id}")
    OrganicPet replaceOrganicPet(@RequestBody OrganicPet newOrganicPet, @PathVariable Long id) {
    
    return repository.findById(id)
        .map(organicPet -> {
        organicPet.setName(newOrganicPet.getName());
        organicPet.setDescription(newOrganicPet.getDescription());
        return repository.save(organicPet);
        })
        .orElseGet(() -> {
        newOrganicPet.setId(id);
        return repository.save(newOrganicPet);
        });
    }

    @DeleteMapping("/organic pet/{id}")
    void deleteOrganicPet(@PathVariable Long id) {
    repository.deleteById(id);
    }
}