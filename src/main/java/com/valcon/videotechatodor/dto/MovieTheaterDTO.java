package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.RoomType;

import java.io.Serializable;

public class MovieTheaterDTO implements Serializable {

    private final RoomType roomType;

    private final int capacity;

    public MovieTheaterDTO(RoomType roomType, int capacity) {
        this.roomType = roomType;
        this.capacity = capacity;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public int getCapacity() {
        return capacity;
    }

}
