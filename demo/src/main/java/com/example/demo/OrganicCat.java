package com.example.demo;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
class OrganicCat extends OrganicPet{

    private @Id @GeneratedValue Long id;
    private int litterBoxCleanliness;

    OrganicCat() {}

    OrganicCat(String name, String Description) {
        super(name, description);
        this.thirst = 44;
        this.hunger = 38;
        this.boredom = 53;
        this.litterBoxCleanliness = 47;
    }

    public Long getId() {
        return this.id;
    }

    public int getLitterBoxCleanliness() {
        return this.cageCleanliness; 
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {

    if (this == o)
        return true;
    if (!(o instanceof OrganicCat))
        return false;
    OrganicCat OrganicCat = (OrganicCat) o;
        return Objects.equals(this.id, organicCat.id) && Objects.equals(this.litterBoxCleanliness, organicCat.litterBoxCleanliness); 
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.litterBoxCleanliness);
    }

    @Override
    public String toString() {
        return "OrganicCat{" + "id=" + this.id +
        ", litterBoxCleanliness='" + this.litterBoxCleanliness+"}";
    }
}
