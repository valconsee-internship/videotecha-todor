package com.valcon.videotechatodor.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProjectionDTO implements Serializable {

    private final Long projectionId;

    private final MovieDTO movie;

    private final TheaterInfoDTO theater;

    private final LocalDateTime startTime;

    private final Double ticketPrice;

    private final int numberOfSeats;

    public ProjectionDTO(Long projectionId, MovieDTO movie, TheaterInfoDTO theater, LocalDateTime startTime, Double ticketPrice, int numberOfSeats) {
        this.projectionId = projectionId;
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
        this.numberOfSeats = numberOfSeats;
    }

    public Long getProjectionId() {
        return projectionId;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public TheaterInfoDTO getTheater() {
        return theater;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }
}
