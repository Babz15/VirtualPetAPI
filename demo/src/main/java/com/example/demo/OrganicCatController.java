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
class OrganicCatController {

    private final OrganicCatRepository repository;

    OrganicCatController(OrganicCatRepository repository) {
        this.repository = repository;
    }


  // Aggregate root
  // tag::get-aggregate-root[]
    @GetMapping("/organiccats")
    List<OrganicCat> all() {
    return repository.findAll();
    }
  // end::get-aggregate-root[]

    @PostMapping("/organiccats")
    OrganicCat newOrganicCat(@RequestBody OrganicCat newOrganicCat) {
        return repository.save(newOrganicCat);
    }

  // Single item

    @GetMapping("/organiccats/{id}")
    OrganicCat one(@PathVariable Long id) {
    
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException());
    }

    @PutMapping("/organiccats/{id}")
    OrganicCat replaceOrganicCat(@RequestBody OrganicCat newOrganicCat, @PathVariable Long id) {
    
    return repository.findById(id)
        .map(organicCat -> {
        organicCat.setName(newOrganicCat.getName());
        organicCat.setDescription(newOrganicCat.getDescription());
        return repository.save(organicCat);
        })
        .orElseGet(() -> {
        newOrganicCat.setId(id);
        return repository.save(newOrganicCat);
        });
    }

    @DeleteMapping("/organiccat/{id}")
    void deleteOrganicCat(@PathVariable Long id) {
    repository.deleteById(id);
    }
}
