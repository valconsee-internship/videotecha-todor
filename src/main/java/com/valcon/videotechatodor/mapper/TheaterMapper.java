package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.TheaterDTO;
import com.valcon.videotechatodor.model.Theater;

public class TheaterMapper {

    public static TheaterDTO toDTO(Theater theater){
        return new TheaterDTO(theater.getRoomType(), theater.getCapacity());
    }

}
