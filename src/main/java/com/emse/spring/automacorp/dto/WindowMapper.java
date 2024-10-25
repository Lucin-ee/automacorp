package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.command.WindowCommand;
import com.emse.spring.automacorp.model.RoomEntity;
import com.emse.spring.automacorp.model.WindowEntity;

public class WindowMapper {
    public static WindowDto toDto(WindowEntity entity) {
        return new WindowDto(
                entity.getId(),
                entity.getName(),
                entity.getWindowStatus(), // Utilisation de WindowStatus directement
                entity.getRoom() != null ? entity.getRoom().getId() : null
        );
    }

    public static WindowEntity toEntity(WindowCommand windowCommand, RoomEntity room) {
        WindowEntity window = new WindowEntity();
        window.setId(windowCommand.roomId()); // Correction ici pour utiliser le roomId
        window.setName(windowCommand.name());
        window.setWindowStatus(windowCommand.windowStatus()); // Utilisation de WindowStatus dans la commande
        window.setRoom(room);
        return window;
    }
}






