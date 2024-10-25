package com.emse.spring.automacorp.dto;

import java.util.List;

public class RoomDto {
    private Long id;
    private Integer floor;
    private String name;
    private Double targetTemperature;
    private Long currentTemperatureSensorId;

    public RoomDto(Long id, Integer floor, String name, Double targetTemperature, Long currentTemperatureSensorId) {
        this.id = id;
        this.floor = floor;
        this.name = name;
        this.targetTemperature = targetTemperature;
        this.currentTemperatureSensorId = currentTemperatureSensorId;
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

    public Double getTargetTemperature() {
        return targetTemperature;
    }

    public void setTargetTemperature(Double targetTemperature) {
        this.targetTemperature = targetTemperature;
    }

    public Long getCurrentTemperatureSensorId() {
        return currentTemperatureSensorId;
    }

    public void setCurrentTemperatureSensorId(Long currentTemperatureSensorId) {
        this.currentTemperatureSensorId = currentTemperatureSensorId;
    }
}


