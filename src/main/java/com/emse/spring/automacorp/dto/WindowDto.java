package com.emse.spring.automacorp.dto;


import com.emse.spring.automacorp.model.WindowStatus;

public class WindowDto {
    private Long id;
    private String name;
    private Long windowStatusSensorId;

    public WindowDto(Long id, String name, WindowStatus windowStatus, Long windowStatusSensorId) {
        this.id = id;
        this.name = name;
        this.windowStatusSensorId = windowStatusSensorId;
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

    public Long getWindowStatusSensorId() {
        return windowStatusSensorId;
    }

    public void setWindowStatusSensorId(Long windowStatusSensorId) {
        this.windowStatusSensorId = windowStatusSensorId;
    }
}