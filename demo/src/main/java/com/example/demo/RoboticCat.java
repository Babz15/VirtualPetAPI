package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class RoboticCat extends RoboticPet{

    private @Id @GeneratedValue Long id;

    RoboticCat() {}

    RoboticCat(String name, String Description) {
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
    if (!(o instanceof RoboticCat))
        return false;
    RoboticCat RoboticCat = (RoboticCat) o;
        return Objects.equals(this.id, RoboticCat.id); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "RoboticCat{" + "id=" + this.id + "}";
    }
}