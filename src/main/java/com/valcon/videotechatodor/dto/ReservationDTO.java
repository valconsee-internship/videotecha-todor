package com.valcon.videotechatodor.dto;

public class ReservationDTO {

    private final Long reservationId;

    private final ProjectionDTO projectionDTO;

    public ReservationDTO(Long reservationId, ProjectionDTO projectionDTO) {
        this.reservationId = reservationId;
        this.projectionDTO = projectionDTO;
    }

    public Long getReservationId() {
        return reservationId;
    }

    public ProjectionDTO getProjectionDTO() {
        return projectionDTO;
    }

}
