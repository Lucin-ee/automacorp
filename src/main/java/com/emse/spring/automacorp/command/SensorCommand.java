package com.emse.spring.automacorp.command;

import com.emse.spring.automacorp.model.SensorType;

public record SensorCommand(String name, Double value, SensorType sensorType) {}

