package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.ReservationCreateDTO;
import com.valcon.videotechatodor.dto.ReservationDTO;
import com.valcon.videotechatodor.mapper.ReservationMapper;
import com.valcon.videotechatodor.model.Projection;
import com.valcon.videotechatodor.model.Reservation;
import com.valcon.videotechatodor.model.User;
import com.valcon.videotechatodor.repository.ReservationRepository;
import com.valcon.videotechatodor.service.ProjectionService;
import com.valcon.videotechatodor.service.ReservationService;
import com.valcon.videotechatodor.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;

    private final UserService userService;

    private final ProjectionService projectionService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, UserService userService, ProjectionService projectionService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.projectionService = projectionService;
    }

    @Override
    public ReservationDTO create(ReservationCreateDTO reservationCreateDTO) {
        User user = userService.getOneUser(reservationCreateDTO.getUserId());
        Projection projection = projectionService.getOneProjection(reservationCreateDTO.getProjectionId());
        Reservation reservation = new Reservation(user, projection);
        return ReservationMapper.toDTO(reservationRepository.save(reservation));
    }

}
