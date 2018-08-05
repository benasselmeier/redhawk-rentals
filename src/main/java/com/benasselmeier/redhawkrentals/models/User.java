package com.benasselmeier.redhawkrentals.models;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min = 3, max = 15)
    private String name;

    @ManyToMany
    private List<Equipment> rentals;

    public void addItem(Equipment item) {
        rentals.add(item);
    }

    public User() { }

    //Getters and setters

    public int getId() { return id; }

    public String getName() { return name; }

    public List<Equipment> getRentals() { return rentals; }

    public void setName(String name) { this.name = name; }

}
