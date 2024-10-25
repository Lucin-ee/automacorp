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
                entity.getFloor(),
                entity.getName(),
                entity.getTargetTemperature(),
                entity.getCurrentTemperature().getId()
        );
    }

    public RoomRecord toRecord(RoomEntity dto) {

        return new RoomRecord(
                dto.getId(),
                dto.getFloor(),
                dto.getName(),
                dto.getTargetTemperature(),
                dto.getCurrentTemperature().getId()
        );
    }

    public RoomEntity toEntity(RoomDto dto, SensorEntity cuurent) {
        RoomEntity room = new RoomEntity();
        room.setId(dto.getId());
        room.setFloor(dto.getFloor());
        room.setName(dto.getName());
        room.setTargetTemperature(dto.getTargetTemperature());
        room.setCurrentTemperature(cuurent);
        return room;
    }
}