package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.WindowEntity;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest //
class WindowDaoTest {
    @Autowired //
    private WindowDao windowDao;

    @Test
    public void shouldFindAWindowById() {
        WindowEntity window = windowDao.getReferenceById(-10L); //
        Assertions.assertThat(window.getName()).isEqualTo("Window 1");
        Assertions.assertThat(window.getWindowStatus().getValue()).isEqualTo(1.0);
    }

    @Test
    public void shouldFindRoomsWithOpenWindows() {
        List<WindowEntity> result = windowDao.findRoomsWithOpenWindows(-10L);
        Assertions.assertThat(result)
                .hasSize(1)
                .extracting("id", "name")
                .containsExactly(Tuple.tuple(-10L, "Window 1"));
    }

    @Test
    public void shouldNotFindRoomsWithOpenWindows() {
        List<WindowEntity> result = windowDao.findRoomsWithOpenWindows(-9L);
        Assertions.assertThat(result).isEmpty();
    }

    @Test
    public void shouldFindWindowsByRoomName() {
        List<WindowEntity> windows = windowDao.findWindowsByRoomName("Room1");
        Assertions.assertThat(windows).isNotEmpty(); // Adjust assertion as needed
    }

    @Test
    public void shouldDeleteAllWindowsInRoom() {
        Long roomId = -10L;
        windowDao.deleteAllWindowsInRoom(roomId);

        List<WindowEntity> windows = windowDao.findWindowsByRoomName("Room1");
        Assertions.assertThat(windows).isEmpty();
    }

    @Test
    public void shouldChangeAllWindowsStatusInRoom() {
        Long roomId = -10L;
        windowDao.changeAllWindowsStatusInRoom(roomId, true);
        List<WindowEntity> windows = windowDao.findWindowsByRoomName("Room1");
        Assertions.assertThat(windows).allMatch(window -> window.getWindowStatus().getValue().equals(1.0));
    }
}
