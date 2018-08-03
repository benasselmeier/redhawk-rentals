package com.benasselmeier.redhawkrentals.models;

        import javax.persistence.*;
        import javax.validation.constraints.NotNull;
        import javax.validation.constraints.Size;
        import java.util.ArrayList;
        import java.util.List;

@Entity
public class Equipment {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=20)
    private String name;

    @ManyToOne
    private Category category;

    @NotNull
    private int quantity;

    // Getters and Setters

    public String getName() { return this.name; }

    public void setName (String name) { this.name = name; }

    public int getId() { return this.id; }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
