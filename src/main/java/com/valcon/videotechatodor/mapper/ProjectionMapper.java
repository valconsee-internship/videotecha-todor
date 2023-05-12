package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.ProjectionDTO;
import com.valcon.videotechatodor.model.Projection;

public class ProjectionMapper {

    public static ProjectionDTO toDTO(Projection projection){
        return new ProjectionDTO(MovieMapper.toDTO(projection.getMovie()),
                TheaterMapper.toDTO(projection.getTheater()),
                projection.getStartTime(),
                projection.getTicketPrice());
    }

    private ProjectionMapper() {
    }
}
