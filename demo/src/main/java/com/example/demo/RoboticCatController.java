package com.example.demo;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RoboticCatController {

    private final RoboticCatRepository repository;

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);


    RoboticCatController(RoboticCatRepository repository) {
        this.repository = repository;
    }


  // Aggregate root
  // tag::get-aggregate-root[]
    @GetMapping("/roboticcats")
    List<RoboticCat> all() {
    return repository.findAll();
    }
  // end::get-aggregate-root[]

    @PostMapping("/roboticcats")
    RoboticCat newRoboticCat(@RequestBody RoboticCat newRoboticCat) {
        return repository.save(newRoboticCat);
    }

  // Single item

    @GetMapping("/roboticcats/{id}")
    RoboticCat one(@PathVariable Long id) {
    
        return repository.findById(id)
        .orElseThrow(() -> new RuntimeException());
}

    @PutMapping("/roboticcats/{id}")
    RoboticCat replaceRoboticCat(@RequestBody RoboticCat newRoboticCat, @PathVariable Long id) {
    
    return repository.findById(id)
        .map(roboticCat -> {
        roboticCat.setName(newRoboticCat.getName());
        roboticCat.setDescription(newRoboticCat.getDescription());
        return repository.save(roboticCat);
        })
        .orElseGet(() -> {
        newRoboticCat.setId(id);
        return repository.save(newRoboticCat);
        });
    }

    @DeleteMapping("/roboticcat/{id}")
    void deleteRoboticCat(@PathVariable Long id) {
    repository.deleteById(id);
    }
}
