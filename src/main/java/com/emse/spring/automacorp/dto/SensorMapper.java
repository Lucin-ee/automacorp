package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.command.SensorCommand;
import com.emse.spring.automacorp.dto.SensorDto;
import com.emse.spring.automacorp.model.SensorEntity;
import org.springframework.stereotype.Component;

public class SensorMapper {
    public static SensorDto toDto(SensorEntity entity) {
        return new SensorDto(
                entity.getId(),
                entity.getName(),
                entity.getValue(),
                entity.getSensorType()
        );
    }

    public static SensorEntity toEntity(SensorCommand command) {
        SensorEntity entity = new SensorEntity();
        entity.setName(command.name());
        entity.setSensorType(command.sensorType());
        entity.setValue(command.value());
        return entity;
    }
}

