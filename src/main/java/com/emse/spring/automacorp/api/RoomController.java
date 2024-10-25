package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.command.RoomCommand;
import com.emse.spring.automacorp.dto.RoomDto;
import com.emse.spring.automacorp.dto.RoomMapper;
import com.emse.spring.automacorp.model.RoomEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.emse.spring.automacorp.model.WindowStatus;

import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private List<RoomEntity> roomStorage = new ArrayList<>();

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        Optional<RoomEntity> roomOpt = roomStorage.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
        if (roomOpt.isPresent()) {
            roomStorage.remove(roomOpt.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{room_id}/openWindows")
    public ResponseEntity<Void> openRoomWindows(@PathVariable Long room_id) {
        Optional<RoomEntity> roomOpt = roomStorage.stream()
                .filter(r -> r.getId().equals(room_id))
                .findFirst();
        if (roomOpt.isPresent()) {
            RoomEntity room = roomOpt.get();
            room.getWindows().forEach(window -> window.setWindowStatus(WindowStatus.OPEN)); // Assuming WindowStatus.OPEN means open
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{room_id}/closeWindows")
    public ResponseEntity<Void> closeRoomWindows(@PathVariable Long room_id) {
        Optional<RoomEntity> roomOpt = roomStorage.stream()
                .filter(r -> r.getId().equals(room_id))
                .findFirst();
        if (roomOpt.isPresent()) {
            RoomEntity room = roomOpt.get();
            room.getWindows().forEach(window -> window.setWindowStatus(WindowStatus.CLOSE)); // Assuming WindowStatus.CLOSED means closed
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<RoomEntity> createRoom(@RequestBody RoomCommand roomCommand) {
        RoomEntity newRoom = new RoomEntity();
        newRoom.setName(roomCommand.name());
        newRoom.setFloor(roomCommand.floor());
        newRoom.setTargetTemperature(roomCommand.targetTemperature());
        roomStorage.add(newRoom);
        return ResponseEntity.ok(newRoom);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoomEntity> updateRoom(@PathVariable Long id, @RequestBody RoomCommand roomCommand) {
        Optional<RoomEntity> roomOpt = roomStorage.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst();
        if (roomOpt.isPresent()) {
            RoomEntity room = roomOpt.get();
            room.setName(roomCommand.name());
            room.setFloor(roomCommand.floor());
            room.setTargetTemperature(roomCommand.targetTemperature());
            return ResponseEntity.ok(room);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


