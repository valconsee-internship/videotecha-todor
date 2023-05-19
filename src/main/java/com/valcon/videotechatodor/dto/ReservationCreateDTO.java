package com.valcon.videotechatodor.dto;

import java.io.Serializable;

public class ReservationCreateDTO implements Serializable {

    private final Long userId;

    private final Long projectionId;

    private final int ticketAmount;

    public ReservationCreateDTO(Long userId, Long projectionId, int ticketAmount) {
        this.userId = userId;
        this.projectionId = projectionId;
        this.ticketAmount = ticketAmount;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public int getTicketAmount() {
        return ticketAmount;
    }

}
