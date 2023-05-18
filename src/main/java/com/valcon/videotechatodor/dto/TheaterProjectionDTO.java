package com.valcon.videotechatodor.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TheaterProjectionDTO implements Serializable {

    private final Long projectionId;

    private final TheaterMovieDTO movie;

    private final LocalDateTime startTime;

    private final Double ticketPrice;

    public TheaterProjectionDTO(Long projectionId, TheaterMovieDTO movie, LocalDateTime startTime, Double ticketPrice) {
        this.projectionId = projectionId;
        this.movie = movie;
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public TheaterMovieDTO getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }
}
