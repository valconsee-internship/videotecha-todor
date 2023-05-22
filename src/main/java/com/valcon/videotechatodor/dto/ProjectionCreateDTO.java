package com.valcon.videotechatodor.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProjectionCreateDTO implements Serializable {

    @NotNull
    private final Long movieId;

    @NotNull
    private final Long theaterId;

    @Future
    private final LocalDateTime startTime;

    @Positive
    @NotNull
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
