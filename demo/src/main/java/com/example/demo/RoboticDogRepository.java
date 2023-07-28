package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface RoboticDogRepository extends RoboticPetRepository<RoboticDog, Long> {

}