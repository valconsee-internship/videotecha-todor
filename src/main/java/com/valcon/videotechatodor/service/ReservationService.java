package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.ReservationCreateDTO;
import com.valcon.videotechatodor.dto.ReservationDTO;
import com.valcon.videotechatodor.model.Reservation;

public interface ReservationService {

    ReservationDTO create(ReservationCreateDTO reservationCreateDTO);
    Reservation getOne(Long id);
    void cancel(Long id);

}
