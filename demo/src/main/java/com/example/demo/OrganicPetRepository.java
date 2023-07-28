package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrganicPetRepository extends VirtualPetRepository<OrganicPet, Long> {

}
