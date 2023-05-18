package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.TheaterProjectionDTO;
import com.valcon.videotechatodor.model.Projection;

import java.util.List;

public class TheaterProjectionMapper {

    public static List<TheaterProjectionDTO> toDTO(List<Projection> projections) {
        return projections.stream()
                .map(p -> new TheaterProjectionDTO(p.getId(), TheaterMovieMapper.toDTO(p.getMovie()), p.getStartTime(), p.getTicketPrice()))
                .toList();
    }

}
