package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.TheaterInfoDTO;
import com.valcon.videotechatodor.model.Theater;

public class TheaterInfoMapper {

    public static TheaterInfoDTO toDTO(Theater theater) {
        return new TheaterInfoDTO(theater.getRoomType(), theater.getCapacity());
    }

}
