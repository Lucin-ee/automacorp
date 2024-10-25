package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.WindowMapper;
import com.emse.spring.automacorp.dto.WindowRecord;
import com.emse.spring.automacorp.model.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WindowMapperTest {

    @Test
    public void shouldMapWindowEntityToWindowRecord() {
        // Arrange: Create a RoomEntity and SensorEntity
        RoomEntity roomEntity = new RoomEntity();
        roomEntity.setId(1L);
        roomEntity.setName("Living Room");

        SensorEntity sensorEntity = new SensorEntity();
        sensorEntity.setId(1L);
        sensorEntity.setName("Window Sensor");
        sensorEntity.setValue(1.0);
        sensorEntity.setSensorType(SensorType.STATUS);

        // Arrange: Create a WindowEntity with sample data
        WindowEntity windowEntity = new WindowEntity();
        windowEntity.setId(1L);
        windowEntity.setName("Window 1");
        windowEntity.setRoom(roomEntity);
        windowEntity.setWindowStatus(sensorEntity);

        // Act: Use the mapper to convert the entity to a record
        WindowRecord windowRecord = WindowMapper.of(windowEntity);

        // Assert: Check that all fields are correctly mapped
        assertThat(windowRecord.id()).isEqualTo(1L);
        assertThat(windowRecord.name()).isEqualTo("Window 1");
        assertThat(windowRecord.room().name()).isEqualTo("Living Room");
        assertThat(windowRecord.windowStatus().name()).isEqualTo("Window Sensor");
    }
}
