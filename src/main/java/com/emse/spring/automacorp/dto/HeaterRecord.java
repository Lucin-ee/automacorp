package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.model.HeaterStatus;
import com.emse.spring.automacorp.model.RoomEntity;

public record HeaterRecord(Long id, String name, HeaterStatus status) {
}

