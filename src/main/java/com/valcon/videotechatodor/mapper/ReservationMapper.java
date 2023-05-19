package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.ReservationDTO;
import com.valcon.videotechatodor.model.Reservation;

public class ReservationMapper {

    public static ReservationDTO toDTO(Reservation reservation) {
        return new ReservationDTO(reservation.getId(), ProjectionMapper.toDTO(reservation.getProjection()));
    }

}
