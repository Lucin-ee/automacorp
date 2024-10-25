package com.emse.spring.automacorp.mapper;

import com.emse.spring.automacorp.dto.RoomMapper;
import com.emse.spring.automacorp.dto.RoomRecord;
import com.emse.spring.automacorp.dto.WindowMapper;
import com.emse.spring.automacorp.model.HeaterStatus;
import com.emse.spring.automacorp.model.WindowStatus;
import com.emse.spring.automacorp.model.RoomEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Comparator;
import java.util.List;

class RoomMapperTest {

    @Test
    void shouldMapRoom() {
        // Arrange
        RoomEntity roomEntity = FakeEntityBuilder.createRoomEntity(11L, "Room1Building");

        // Act
        RoomRecord room = RoomMapper.of(roomEntity);

        // Assert
        RoomRecord expectedRoom = new RoomRecord(
                11L,
                null,
                null,
                26.4,
                null
        );
        Assertions.assertThat(room).usingRecursiveAssertion().isEqualTo(expectedRoom);
    }
}