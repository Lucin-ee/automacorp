package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.command.SensorCommand;
import com.emse.spring.automacorp.model.SensorEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {
    private List<SensorEntity> sensorStorage = new ArrayList<>();

    @PostMapping
    public ResponseEntity<SensorEntity> createSensor(@RequestBody SensorCommand sensorCommand) {
        SensorEntity newSensor = new SensorEntity();
        newSensor.setName(sensorCommand.name());
        newSensor.setValue(sensorCommand.value());
        newSensor.setSensorType(sensorCommand.sensorType());
        sensorStorage.add(newSensor);
        return ResponseEntity.ok(newSensor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SensorEntity> updateSensor(@PathVariable Long id, @RequestBody SensorCommand sensorCommand) {
        Optional<SensorEntity> sensorOpt = sensorStorage.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst();
        if (sensorOpt.isPresent()) {
            SensorEntity sensor = sensorOpt.get();
            sensor.setName(sensorCommand.name());
            sensor.setValue(sensorCommand.value());
            sensor.setSensorType(sensorCommand.sensorType());
            return ResponseEntity.ok(sensor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

