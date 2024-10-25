package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.dto.HeaterRecord;
import com.emse.spring.automacorp.model.HeaterEntity;

import org.springframework.stereotype.Component;

import org.springframework.stereotype.Component;

@Component
public class HeaterMapper {
    public HeaterDto toDto(HeaterEntity entity) {
        if (entity == null) {
            return null;
        }
        return new HeaterDto(entity.getId(), entity.getName(), entity.getStatus());
    }

    public HeaterEntity toEntity(HeaterDto dto) {
        if (dto == null) {
            return null;
        }
        HeaterEntity entity = new HeaterEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setStatus(dto.getStatus());
        return entity;
    }
}


