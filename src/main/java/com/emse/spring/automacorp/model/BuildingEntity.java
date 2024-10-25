package com.emse.spring.automacorp.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "SP_BUILDING")
public class BuildingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Automatically generates an ID
    private Long id;

    @Column(nullable = false, length = 100) // Building name cannot be null
    private String name;

    @Column(nullable = false, length = 255) // Address field for the building
    private String address;

    @Column(name = "number_of_floors", nullable = false)
    private int numberOfFloors;

    // One building can have many rooms
    @OneToMany(cascade = CascadeType.ALL)
    private List<RoomEntity> rooms;

    // Default constructor (required by JPA)
    public BuildingEntity() {}

    // Constructor with fields
    public BuildingEntity(String name, String address, int numberOfFloors) {
        this.name = name;
        this.address = address;
        this.numberOfFloors = numberOfFloors;
    }

    public BuildingEntity(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public List<RoomEntity> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomEntity> rooms) {
        this.rooms = rooms;
    }


}

