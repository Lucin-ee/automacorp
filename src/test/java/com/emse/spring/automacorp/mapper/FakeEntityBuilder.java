package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.model.*;

import java.util.List;
import java.util.Set;

import static com.emse.spring.automacorp.model.SensorType.TEMPERATURE;

public class FakeEntityBuilder {

    public static RoomEntity createRoomEntity(Long id, String name) {
        // Sensor is recreated before each test
        RoomEntity entity = new RoomEntity(
                name,
                createSensorEntity(1L, "Temp", TEMPERATURE, 23.2),
                1);

        entity.setTargetTemperature(26.4);
        entity.setId(id);
        entity.setWindows(List.of(
                createWindowEntity(id * 10 + 1L, "Window1" + name, entity),
                createWindowEntity(id * 10 + 2L, "Window2" + name, entity)
        ));
        return entity;
    }

    public static WindowEntity createWindowEntity(Long id, String name, RoomEntity roomEntity) {
        // Sensor is recreated before each test
        WindowEntity windowEntity = new WindowEntity(
                name,
                createSensorEntity(id * 10 + 1L, "Status" + id, SensorType.STATUS, 0.0),
                roomEntity
        );
        windowEntity.setId(id);
        return windowEntity;
    }

    public static HeaterEntity createHeaterEntity(Long id, String name, RoomEntity roomEntity) {
        // Sensor is recreated before each test
        HeaterEntity heaterEntity = new HeaterEntity(
                name,
                createSensorEntity(id * 10 + 1L, "Status" + id, SensorType.STATUS, 0.0),
                roomEntity
        );
        heaterEntity.setId(id);
        return heaterEntity;
    }

    public static SensorEntity createSensorEntity(Long id, String name, SensorType type, Double value) {
        // Sensor is recreated before each test
        SensorEntity sensorEntity = new SensorEntity(type, name);
        sensorEntity.setId(id);
        sensorEntity.setValue(value);
        return sensorEntity;
    }
}