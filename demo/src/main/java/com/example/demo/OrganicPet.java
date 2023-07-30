package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class OrganicPet extends VirtualPet{

    private @Id @GeneratedValue Long id;
    protected int hunger;
    protected int thirst;

    OrganicPet() {}

    OrganicPet(String name, String description) {
        super(name, description);
        this.hunger = hunger;
        this.thirst = thirst;
    }

    public Long getId() {
        return this.id;
    }

    public int getHunger() {
        return this.hunger;
    }

    public int getThirst() {
        return this.thirst;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHunger(int hunger){
        this.hunger = hunger;
    }

    public void setThirst(int thirst) {
        this.thirst = thirst;
    }

    @Override
    public boolean equals(Object o) {

    if (this == o)
        return true;
    if (!(o instanceof OrganicPet))
        return false;
    OrganicPet organicPet = (OrganicPet) o;
        return Objects.equals(this.id, organicPet.id) && Objects.equals(this.hunger, organicPet.hunger) && 
        Objects.equals(this.thirst, organicPet.thirst);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.hunger, this.thirst);
    }

    @Override
    public String toString() {
        return "OrganicPet{" + "id=" + this.id +
        ", hunger='" + this.hunger + '\'' + ", thirst='" + this.thirst + "}";
    }
}
