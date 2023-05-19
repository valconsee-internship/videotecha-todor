package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.TheaterDTO;
import com.valcon.videotechatodor.dto.TheaterInfoDTO;
import com.valcon.videotechatodor.model.Theater;

public class TheaterMapper {

    public static TheaterDTO toDTO(Theater theater){
        return new TheaterDTO(theater.getRoomType(), theater.getCapacity(), TheaterProjectionMapper.toDTO(theater.getProjections()));
    }

    public static Theater toEntity(TheaterInfoDTO theaterDTO){
        return new Theater(theaterDTO.getRoomType(), theaterDTO.getCapacity());
    }

    private TheaterMapper() {
    }

}
