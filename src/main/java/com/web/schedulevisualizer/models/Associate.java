package com.web.schedulevisualizer.models;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "ASSOCIATE")
public class Associate {
    // Columns: PersonID | lastName | firstName

    // Primary Key
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer personID;

    @Column
    private String lastName;

    @Column
    private String firstName;

    @OneToMany(mappedBy="associate")
    private Set<Schedule> schedules;




    // Getters
    public Integer getPersonID() { return personID; }
    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }

    // Setters
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

}
