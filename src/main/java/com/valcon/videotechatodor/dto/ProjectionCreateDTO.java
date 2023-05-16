package com.valcon.videotechatodor.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ProjectionCreateDTO implements Serializable {

    private final Long movieId;

    private final Long theaterId;

    private final LocalDateTime startTime;

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
