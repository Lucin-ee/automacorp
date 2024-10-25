package com.emse.spring.automacorp.dao;
// import com.emse.spring.automacorp.model.Window;
import com.emse.spring.automacorp.model.WindowEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


public class WindowDaoCustomImpl implements WindowDaoCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<WindowEntity> findRoomsWithOpenWindows(Long id) {
        String jpql = "select w from WindowEntity w inner join w.windowStatus s " +
                "where w.room.id = :id and s.value > 0.0 order by w.name";
        return em.createQuery(jpql, WindowEntity.class)
                .setParameter("id", id)
                .getResultList();
    }

    public List<WindowEntity> findWindowsByRoomName(String roomName) {
        String jpql = "SELECT w FROM WindowEntity w JOIN w.room r WHERE r.name = :roomName";
        return em.createQuery(jpql, WindowEntity.class)
                .setParameter("roomName", roomName)
                .getResultList();
    }

    public void deleteAllWindowsInRoom(Long roomId) {
        String jpql = "DELETE FROM WindowEntity w WHERE w.room.id = :roomId";
        em.createQuery(jpql)
                .setParameter("roomId", roomId)
                .executeUpdate();
    }

    public void changeAllWindowsStatusInRoom(Long roomId, boolean open) {
        String jpql = "UPDATE SensorEntity s SET s.value = :value WHERE s.id IN (SELECT w.windowStatus.id FROM WindowEntity w WHERE w.room.id = :roomId)";
        em.createQuery(jpql)
                .setParameter("value", 1.0)
                .setParameter("roomId", roomId)
                .executeUpdate();
    }
}