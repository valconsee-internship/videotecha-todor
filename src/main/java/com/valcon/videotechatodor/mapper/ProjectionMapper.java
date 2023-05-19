package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.ProjectionDTO;
import com.valcon.videotechatodor.model.Projection;

public class ProjectionMapper {

    public static ProjectionDTO toDTO(Projection projection){
        return new ProjectionDTO(projection.getId(), MovieInfoMapper.toDTO(projection.getMovie()),
                TheaterInfoMapper.toDTO(projection.getTheater()),
                projection.getStartTime(),
                projection.getTicketPrice(),
                projection.getAvailableSeats());
    }

    public static Projection toEntity(ProjectionDTO projectionDTO){
        return new Projection(MovieMapper.toEntity(projectionDTO.getMovie()),
                TheaterMapper.toEntity(projectionDTO.getTheater()),
                projectionDTO.getStartTime(), projectionDTO.getTicketPrice(),
                projectionDTO.getNumberOfSeats());
    }

    private ProjectionMapper() {
    }

}
