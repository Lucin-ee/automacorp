package com.emse.spring.automacorp.dto;

import com.emse.spring.automacorp.model.HeaterStatus;

public class HeaterDto {
    private Long id;
    private String name;
    private HeaterStatus status;

    public HeaterDto(Long id, String name, HeaterStatus status) {
        this.id = id;
        this.name = name;
        this.status = status;
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
}
