package com.valcon.videotechatodor.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProjectionCreateDTO implements Serializable {

    @NotNull(message = "Movie is required. ")
    private final Long movieId;

    @NotNull(message = "Theater is required. ")
    private final Long theaterId;

    @Future(message = "Projection start time cannot be in the past. ")
    @NotNull(message = "Start time is required. ")
    private final LocalDateTime startTime;

    @Positive(message = "Ticket price cannot be negative. ")
    @NotNull(message = "Ticket price is required. ")
    private final Double ticketPrice;

    public ProjectionCreateDTO(Long movieId, Long theaterId, LocalDateTime startTime, Double ticketPrice) {
        this.movieId = movieId;
        this.theaterId = theaterId;
        this.startTime = startTime;
        this.ticketPrice = ticketPrice;
    }

    public Long getMovieId() {
        return movieId;
    }

    public Long getTheaterId() {
        return theaterId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

}
