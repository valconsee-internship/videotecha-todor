package com.valcon.videotechatodor.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProjectionDTO implements Serializable {

    private final MovieDTO movie;

    private final TheaterDTO theater;

    private final LocalDateTime startTime;

    private final Double ticketPrice;

    public ProjectionDTO(MovieDTO movie, TheaterDTO theater, LocalDateTime startTime, Double ticketPrice) {
        this.movie = movie;
        this.theater = theater;
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
    }

    public MovieDTO getMovie() {
        return movie;
    }

    public TheaterDTO getTheater() {
        return theater;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

}
