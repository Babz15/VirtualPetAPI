package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class OrganicDog extends OrganicPet{

    private @Id @GeneratedValue Long id;
    private int cageCleanliness;

    OrganicDog() {}

    OrganicDog(String name, String Description) {
        super(name, description);
        this.thirst = 39;
        this.hunger = 30;
        this.boredom = 51;
        this.cageCleanliness = 33;
    }

    public Long getId() {
        return this.id;
    }

    public int getCageCleanliness() {
        return this.cageCleanliness;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

    if (this == o)
        return true;
    if (!(o instanceof OrganicDog))
        return false;
    OrganicDog OrganicDog = (OrganicDog) o;
        return Objects.equals(this.id, organicPet.id) && Objects.equals(this.cageCleanliness, organicDog.cageCleanliness); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.cageCleanliness);
    }

    @Override
    public String toString() {
        return "OrganicDog{" + "id=" + this.id +
        ", cageCleanliness='" + this.cageCleanliness + "}";
    }
}