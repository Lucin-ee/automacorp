package com.emse.spring.automacorp.dao;

import com.emse.spring.automacorp.model.RoomEntity;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest //
class RoomDaoTest {
    @Autowired //
    private RoomDao roomDao;

    @Test
    public void shouldFindARoomById() {
        RoomEntity room = roomDao.getReferenceById(-10L); //
        Assertions.assertThat(room.getName()).isEqualTo("Room1");
    }
}
