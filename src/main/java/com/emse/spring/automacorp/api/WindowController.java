package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.command.WindowCommand;
import com.emse.spring.automacorp.model.WindowEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/windows")
public class WindowController {
    private List<WindowEntity> windowStorage = new ArrayList<>();

    @PostMapping
    public ResponseEntity<WindowEntity> createWindow(@RequestBody WindowCommand windowCommand) {
        WindowEntity newWindow = new WindowEntity();
        newWindow.setName(windowCommand.name());
        newWindow.setWindowStatus(windowCommand.windowStatus());
        newWindow.setRoomId(windowCommand.roomId());
        windowStorage.add(newWindow);
        return ResponseEntity.ok(newWindow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WindowEntity> updateWindow(@PathVariable Long id, @RequestBody WindowCommand windowCommand) {
        Optional<WindowEntity> windowOpt = windowStorage.stream()
                .filter(w -> w.getId().equals(id))
                .findFirst();
        if (windowOpt.isPresent()) {
            WindowEntity window = windowOpt.get();
            window.setName(windowCommand.name());
            window.setWindowStatus(windowCommand.windowStatus());
            window.setRoomId(windowCommand.roomId());
            return ResponseEntity.ok(window);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}




