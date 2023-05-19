package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.MovieTheaterDTO;
import com.valcon.videotechatodor.model.Theater;

public class MovieTheaterMapper {

    public static MovieTheaterDTO toDTO(Theater theater){
        return new MovieTheaterDTO(theater.getRoomType(), theater.getCapacity());
    }

}
