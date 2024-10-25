package com.emse.spring.automacorp.command;

import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.SensorEntity;

import com.emse.spring.automacorp.model.HeaterStatus;
public record HeaterCommand(String name, SensorCommand heaterStatus, Long roomId) {}