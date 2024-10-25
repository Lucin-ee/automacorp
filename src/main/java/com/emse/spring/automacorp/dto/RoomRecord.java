package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.model.RoomEntity;

import java.util.List;
import java.util.stream.Collectors;

public record RoomRecord(Long id, Integer floor, String name, Double targetTemperature, Long currentTemperatureSensorId) {
}
