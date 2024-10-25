package com.emse.spring.automacorp.dto;


import com.emse.spring.automacorp.model.SensorType;

public class SensorDto {
    private Long id;
    private String name;
    private Double value;
    private SensorType sensorType;

    public SensorDto(Long id, String name, Double value, SensorType sensorType) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.sensorType = sensorType;
    }

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public SensorType getSensorType() {
        return sensorType;
    }

    public void setSensorType(SensorType sensorType) {
        this.sensorType = sensorType;
    }
}