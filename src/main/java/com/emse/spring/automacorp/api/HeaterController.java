package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.command.HeaterCommand;
import com.emse.spring.automacorp.dao.HeaterDao;
import com.emse.spring.automacorp.dto.HeaterDto;
import com.emse.spring.automacorp.dto.HeaterMapper;
import com.emse.spring.automacorp.dto.SensorMapper;
import com.emse.spring.automacorp.model.HeaterEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/heaters")
public class HeaterController {
    private List<HeaterEntity> heaterStorage = new ArrayList<>();

    @PostMapping
    public ResponseEntity<HeaterEntity> createHeater(@RequestBody HeaterCommand heaterCommand) {
        HeaterEntity newHeater = new HeaterEntity();
        newHeater.setName(heaterCommand.name());
        newHeater.setStatus(heaterCommand.heaterStatus());
        heaterStorage.add(newHeater);
        return ResponseEntity.ok(newHeater);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HeaterEntity> updateHeater(@PathVariable Long id, @RequestBody HeaterCommand heaterCommand) {
        Optional<HeaterEntity> heaterOpt = heaterStorage.stream()
                .filter(h -> h.getId().equals(id))
                .findFirst();
        if (heaterOpt.isPresent()) {
            HeaterEntity heater = heaterOpt.get();
            heater.setName(heaterCommand.name());
            heater.setStatus(heaterCommand.heaterStatus());
            return ResponseEntity.ok(heater);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


