package com.emse.spring.automacorp.api;

import com.emse.spring.automacorp.command.WindowCommand;
import com.emse.spring.automacorp.dao.RoomDao;
import com.emse.spring.automacorp.dao.WindowDao;
import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.WindowEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/windows")
public class WindowController {

    private final WindowDao windowDao;
    private final RoomDao roomDao;

    public WindowController(WindowDao windowDao, RoomDao roomDao) {
        this.windowDao = windowDao;
        this.roomDao = roomDao;
    }


    @PostMapping
    public ResponseEntity<WindowEntity> createWindow(@RequestBody WindowCommand windowCommand) {
        RoomEntity roomEntity = roomDao.findById(windowCommand.roomId()).orElseThrow(IllegalArgumentException::new);
        WindowEntity newWindow = new WindowEntity();
        newWindow.setName(windowCommand.name());
        newWindow.setWindowStatus(windowCommand.windowStatus());
        newWindow.setRoom(roomEntity);
        windowDao.save(newWindow);
        return ResponseEntity.ok(newWindow);
    }

    @PutMapping("/{id}")
    public ResponseEntity<WindowEntity> updateWindow(@PathVariable Long id, @RequestBody WindowCommand windowCommand) {
        RoomEntity roomEntity = roomDao.findById(windowCommand.roomId()).orElseThrow(IllegalArgumentException::new);
        WindowEntity windowEntity = windowDao.findById(id).orElseThrow(IllegalArgumentException::new);

        windowEntity.setName(windowCommand.name());
        windowEntity.setWindowStatus(windowCommand.windowStatus());
        windowEntity.setRoom(roomEntity);
            return ResponseEntity.ok(windowEntity);
    }
}




