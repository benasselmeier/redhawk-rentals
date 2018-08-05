package com.benasselmeier.redhawkrentals.models.forms;

import com.benasselmeier.redhawkrentals.models.Equipment;
import com.benasselmeier.redhawkrentals.models.User;

import javax.validation.constraints.NotNull;

public class UserRentalForm {

    private User user;

    private Iterable<Equipment> rentals;

    @NotNull
    private int userId;

    @NotNull
    private int itemId;

    public UserRentalForm () { }

    public UserRentalForm(Iterable<Equipment> rentals, User user) {
        this.rentals = rentals;
        this.user = user;
    }

    //Getters and setters

    public User getUser() { return user; }

    public Iterable<Equipment> getRentals() { return rentals; }

    public int getUserId() { return userId; }

    public void setUserId(int userId) { this.userId = userId; }

    public int getItemId() { return itemId; }

    public void setItemId(int itemId) { this.itemId = itemId;}
}
