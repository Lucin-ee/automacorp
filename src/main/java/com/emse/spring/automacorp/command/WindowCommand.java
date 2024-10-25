package com.emse.spring.automacorp.command;

import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.SensorEntity;
import com.emse.spring.automacorp.model.WindowStatus;

public record WindowCommand(String name, WindowStatus windowStatus, Long roomId) {
}


