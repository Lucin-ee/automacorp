package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.dto.BuildingDto;
import com.emse.spring.automacorp.model.BuildingEntity;
import org.springframework.stereotype.Component;

@Component
public class BuildingMapper {
    public BuildingDto toDto(BuildingEntity entity) {
        if (entity == null) {
            return null;
        }
        return new BuildingDto(entity.getId(), entity.getName(), entity.getAddress());
    }

    public BuildingEntity toEntity(BuildingDto dto) {
        if (dto == null) {
            return null;
        }
        BuildingEntity entity = new BuildingEntity();
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        return entity;
    }
}