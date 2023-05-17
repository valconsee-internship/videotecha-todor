package com.valcon.videotechatodor.dto;

import java.io.Serializable;

public class ReservationCreateDTO implements Serializable {

    private final Long userId;

    private final Long projectionId;

    public ReservationCreateDTO(Long userId, Long projectionId) {
        this.userId = userId;
        this.projectionId = projectionId;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getProjectionId() {
        return projectionId;
    }

}
