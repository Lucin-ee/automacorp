package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.dto.RoomDto;
import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.SensorEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

public class RoomMapper {
    public RoomDto toDto(RoomEntity entity) {
        return new RoomDto(
                entity.getId(),
                entity.getName(),
                entity.getFloor(),
                entity.getTargetTemperature(),
                entity.getWindows().stream().map(WindowMapper::toDto).collect(Collectors.toList())
        );
    }

    public RoomEntity toEntity(RoomDto dto) {
        RoomEntity room = new RoomEntity();
        room.setId(dto.id());
        room.setName(dto.name());
        room.setFloor(dto.floor());
        room.setTargetTemperature(dto.targetTemperature());
        // Skipping windows as they require a bidirectional relationship setup
        return room;
    }
}