package com.valcon.videotechatodor.dto;

import java.io.Serializable;

public class ReservationCreateDTO implements Serializable {

    private final Long userId;

    private final Long projectionId;

    private final int numberOfTicket;

    public ReservationCreateDTO(Long userId, Long projectionId, int numberOfTicket) {
        this.userId = userId;
        this.projectionId = projectionId;
        this.numberOfTicket = numberOfTicket;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public int getNumberOfTicket() {
        return numberOfTicket;
    }

}
