package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class RoboticPet extends VirtualPet{

    private @Id @GeneratedValue Long id;
    private int oilLevel;

    RoboticPet() {}

    RoboticPet(String name, String description) {
        super(name, description);
        this.oilLevel = 50;
    }

    public Long getId() {
        return this.id;
    }

    public int oilLevel() {
        return this.oilLevel;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOilLevel(int oilLevel){
        this.oilLevel = oilLevel;
    }

    @Override
    public boolean equals(Object o) {

    if (this == o)
        return true;
    if (!(o instanceof RoboticPet))
        return false;
    RoboticPet roboticPet = (RoboticPet) o;
        return Objects.equals(this.id, roboticPet.id) && Objects.equals(this.oilLevel, roboticPet.oilLevel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.oilLevel);
    }

    @Override
    public String toString() {
        return "RoboticPet{" + "id=" + this.id + ", oil level='" + this.oilLevel + '\'' + ", description='" +'}';
    }
}