package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.RoomType;

import java.io.Serializable;
import java.util.List;

public class TheaterDTO implements Serializable {

    private final RoomType roomType;

    private final int capacity;

    private final List<TheaterProjectionDTO> projections;

    public TheaterDTO(RoomType roomType, int capacity, List<TheaterProjectionDTO> projections) {
        this.roomType = roomType;
        this.capacity = capacity;
        this.projections = projections;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<TheaterProjectionDTO> getProjections() {
        return projections;
    }

}
