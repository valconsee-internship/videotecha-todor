package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.ReservationCreateDTO;
import com.valcon.videotechatodor.dto.ReservationDTO;

public interface ReservationService {

    ReservationDTO create(ReservationCreateDTO reservationCreateDTO);

}
