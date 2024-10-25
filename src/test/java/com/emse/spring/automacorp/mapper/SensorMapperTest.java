package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.SensorMapper;
import com.emse.spring.automacorp.dto.SensorRecord;
import com.emse.spring.automacorp.model.SensorEntity;
import com.emse.spring.automacorp.model.SensorType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SensorMapperTest {

    @Test
    public void shouldMapSensorEntityToSensorRecord() {
        // Arrange: Create a SensorEntity with sample data
        SensorEntity sensorEntity = new SensorEntity();
        sensorEntity.setId(1L);
        sensorEntity.setName("Temperature Sensor");
        sensorEntity.setValue(25.0);
        sensorEntity.setSensorType(SensorType.TEMPERATURE);

        // Act: Use the mapper to convert the entity to a record
        SensorRecord sensorRecord = SensorMapper.of(sensorEntity);

        // Assert: Check that all fields are correctly mapped
        assertThat(sensorRecord.id()).isEqualTo(1L);
        assertThat(sensorRecord.name()).isEqualTo("Temperature Sensor");
        assertThat(sensorRecord.value()).isEqualTo(25.0);
        assertThat(sensorRecord.sensorType()).isEqualTo(SensorType.TEMPERATURE);
    }
}
