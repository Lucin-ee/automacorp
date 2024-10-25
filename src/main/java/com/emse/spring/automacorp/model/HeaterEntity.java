package com.emse.spring.automacorp.model;

import com.emse.spring.automacorp.command.SensorCommand;
import jakarta.persistence.*;

@Entity
@Table(name = "SP_HEATER")
public class HeaterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private HeaterStatus status;

    @ManyToOne
    @JoinColumn(name = "room_id", nullable = false)
    private RoomEntity room;

    public HeaterEntity() {
    }

    public HeaterEntity(String name, HeaterStatus status, RoomEntity room) {
        this.name = name;
        this.status = status;
        this.room = room;
    }

    public HeaterEntity(String name, SensorEntity sensorEntity, RoomEntity roomEntity) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeaterStatus getStatus() {
        return status;
    }

    public void setStatus(HeaterStatus status) {
        this.status = status;
    }

    public RoomEntity getRoom() {
        return room;
    }

    public void setRoom(RoomEntity room) {
        this.room = room;
    }
}
