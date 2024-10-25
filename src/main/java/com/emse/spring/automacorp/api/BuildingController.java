package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.command.BuildingCommand;
import com.emse.spring.automacorp.model.BuildingEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buildings")
public class BuildingController {
    private List<BuildingEntity> buildingStorage = new ArrayList<>();

    @PostMapping
    public ResponseEntity<BuildingEntity> createBuilding(@RequestBody BuildingCommand buildingCommand) {
        BuildingEntity newBuilding = new BuildingEntity();
        newBuilding.setName(buildingCommand.name());
        newBuilding.setAddress(buildingCommand.address());
        buildingStorage.add(newBuilding);
        return ResponseEntity.ok(newBuilding);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BuildingEntity> updateBuilding(@PathVariable Long id, @RequestBody BuildingCommand buildingCommand) {
        Optional<BuildingEntity> buildingOpt = buildingStorage.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst();
        if (buildingOpt.isPresent()) {
            BuildingEntity building = buildingOpt.get();
            building.setName(buildingCommand.name());
            building.setAddress(buildingCommand.address());
            return ResponseEntity.ok(building);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
