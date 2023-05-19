package com.valcon.videotechatodor.dto;

import java.io.Serializable;

public class ReservationCreateDTO implements Serializable {

    private final Long userId;

    private final Long projectionId;

    private final int numberOfTickets;

    public ReservationCreateDTO(Long userId, Long projectionId, int numberOfTickets) {
        this.userId = userId;
        this.projectionId = projectionId;
        this.numberOfTickets = numberOfTickets;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

}
