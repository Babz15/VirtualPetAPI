package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

interface OrganicCatRepository extends OrganicPetRepository<OrganicCat, Long> {

}