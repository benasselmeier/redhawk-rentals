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

    public Equipment() { }

    public Equipment(String name) {
        this.name = name;
    }

    @OneToMany
    @JoinColumn(name = "item_id")
    private List<Equipment> equipment = new ArrayList<>();

    // Getters and Setters

    public String getName() { return this.name; }

    public void setName (String name) { this.name = name; }

    public int getId() { return this.id; }

}
