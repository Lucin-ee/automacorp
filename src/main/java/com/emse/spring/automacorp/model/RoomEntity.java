package com.emse.spring.automacorp.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity // managed by Hibernate
@Table(name = "SP_ROOM") // Default entity name
public class RoomEntity {
    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use identity strategy for auto-increment
    private Long id;

    @Column(nullable = false)  // Floor number
    private Integer floor;

    @Column(nullable = false, length = 255)  // Room name
    private String name;

    @ManyToOne // Assuming a window can have one status from a sensor
    private SensorEntity currentTemperature; // Updated to use ManyToOne

    @Column  // Target temperature
    private Double targetTemperature;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Bidirectional relationship
    private List<WindowEntity> windows = new ArrayList<>(); // Collection of associated windows

    public RoomEntity() {
    }

    public RoomEntity(Integer floor, String name, SensorType sensorType, Double targetTemperature) {
        this.floor = floor;
        this.name = name;
        this.targetTemperature = targetTemperature;
    }

    public RoomEntity(String name, SensorEntity temp, int i) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SensorEntity getCurrentTemperature() {
        return currentTemperature;
    }

    public void setCurrentTemperature(SensorEntity currentTemperature) {
        this.currentTemperature = currentTemperature;
    }

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public List<WindowEntity> getWindows() {
        return windows;
    }

    public void setWindows(List<WindowEntity> windows) {
        this.windows = windows;
    }

    // Helper method to add a window to the room
    public void addWindow(WindowEntity window) {
        window.setRoom(this); // Set the room in the window
        this.windows.add(window); // Add the window to the collection
    }

    // Helper method to remove a window from the room
    public void removeWindow(WindowEntity window) {
        window.setRoom(null); // Remove the association in the window
        this.windows.remove(window); // Remove the window from the collection
    }
}
