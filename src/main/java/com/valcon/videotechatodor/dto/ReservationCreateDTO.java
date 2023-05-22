package com.valcon.videotechatodor.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class ReservationCreateDTO implements Serializable {

    @NotNull(message = "User id is required")
    private final Long userId;

    @NotNull(message = "Projection id is required")
    private final Long projectionId;

    @Min(value = 1, message = "Minimum number of tickets is 1")
    @Max(value = 5, message = "Maximum number of tickets is 5")
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
