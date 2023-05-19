package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.MovieProjectionDTO;
import com.valcon.videotechatodor.model.Projection;

import java.util.List;

public class MovieProjectionMapper {

    public static List<MovieProjectionDTO> toDTO(List<Projection> projections) {
        return projections.stream()
                .map(p -> new MovieProjectionDTO(p.getId(), MovieTheaterMapper.toDTO(p.getTheater()), p.getStartTime(), p.getTicketPrice()))
                .toList();
    }

}
