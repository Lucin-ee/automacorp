package com.emse.spring.automacorp.command;

public record RoomCommand(String name, Integer floor, Double targetTemperature) {
}
