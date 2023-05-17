package com.valcon.videotechatodor.dto;

public class ReservationDTO {

    private final ProjectionDTO projectionDTO;

    public ReservationDTO(ProjectionDTO projectionDTO) {
        this.projectionDTO = projectionDTO;
    }

    public ProjectionDTO getProjectionDTO() {
        return projectionDTO;
    }

}
