package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface RoboticCatRepository extends RoboticPetRepository<RoboticCat, Long> {

}