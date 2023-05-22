package com.valcon.videotechatodor.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public class ReservationCreateDTO implements Serializable {

    @NotEmpty
    private final Long userId;

    @NotEmpty
    private final Long projectionId;

    @Min(1)
    @Max(5)
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
