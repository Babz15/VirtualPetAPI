package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@MappedSuperClass
class VirtualPet {

    private @Id @GeneratedValue Long id;
    private String name;
    private String description;
    private int boredom;
    private int happiness;

    VirtualPet() {}

    VirtualPet(String name, String description, int boredom, int happiness) {

        this.name = name;
        this.description = description;
        this.boredom = boredom;
        this.happiness = happiness;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getBoredom() {
        return this.boredom;
    }

    public int getHappiness() {
        return this.happiness;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBoredom(int boredom) {
        this.boredom = boredom;
    }

    public void setDescription(int happiness) {
        this.happiness = happiness;
    }

    @Override
    public boolean equals(Object o) {

    if (this == o)
        return true;
    if (!(o instanceof VirtualPet))
        return false;
    VirtualPet virtualPet = (VirtualPet) o;
        return Objects.equals(this.id, virtualPet.id) && Objects.equals(this.name, virtualPet.name)
        && Objects.equals(this.description, virtualPet.description) && Objects.equals(this.boredom, virtualPet.boredom)
        && Objects.equals(this.happiness, virtualPet.happiness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.description, this.boredom, this.happiness);
    }

    @Override
    public String toString() {
        return "VirtualPet{" + "id=" + this.id + ", name='" + this.name + '\'' + ", description='" + 
        this.description + '\'' + ",boredom='" + this.boredom + '\''+",happiness='" + this.happiness +'}';
    }
}