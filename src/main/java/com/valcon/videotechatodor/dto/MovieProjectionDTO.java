package com.valcon.videotechatodor.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class MovieProjectionDTO implements Serializable {

    private final Long projectionId;

    private final MovieTheaterDTO theater;

    private final LocalDateTime startTime;

    private final Double ticketPrice;

    public MovieProjectionDTO(Long projectionId, MovieTheaterDTO theater, LocalDateTime startTime, Double ticketPrice) {
        this.projectionId = projectionId;
        this.theater = theater;
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public MovieTheaterDTO getTheater() {
        return theater;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

}
