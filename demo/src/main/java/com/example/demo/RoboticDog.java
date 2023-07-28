package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class RoboticDog extends RoboticPet{

    private @Id @GeneratedValue Long id;

    RoboticDog() {}

    RoboticDog(String name, String Description) {
        super(name, description);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

    if (this == o)
        return true;
    if (!(o instanceof RoboticDog))
        return false;
    RoboticDog RoboticDog = (RoboticDog) o;
        return Objects.equals(this.id, RoboticDog.id); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "RoboticDog{" + "id=" + this.id + "}";
    }
}