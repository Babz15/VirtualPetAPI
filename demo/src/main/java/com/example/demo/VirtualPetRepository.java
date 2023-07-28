package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface VirtualPetRepository extends JpaRepository<VirtualPet, Long> {

}