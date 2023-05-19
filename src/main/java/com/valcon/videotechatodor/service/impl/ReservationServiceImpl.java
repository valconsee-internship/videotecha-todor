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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional
    public ReservationDTO create(ReservationCreateDTO reservationCreateDTO) {
        User user = userService.getOneUser(reservationCreateDTO.getUserId());
        Projection projection = projectionService.getOneProjection(reservationCreateDTO.getProjectionId());
        boolean isLessOrEqualThenFive = reservationCreateDTO.getTicketAmount() <= 5;
        if(!isLessOrEqualThenFive) {
            throw new RuntimeException("You cannot buy more than 5 tickets");
        }

        int currentAvailableSeats = projection.getAvailableSeats();
        if (currentAvailableSeats < reservationCreateDTO.getTicketAmount()) {
            throw new RuntimeException("No available seats");
        }

        List<Reservation> userReservations = reservationRepository.findAllByUserIdAndProjectionIdAndIsCanceledFalse(reservationCreateDTO.getUserId(), reservationCreateDTO.getProjectionId());
        if (!userReservations.isEmpty()) {
            int numberOfTickets = userReservations
                    .stream()
                    .mapToInt(Reservation::getTicketAmount)
                    .sum();
            if (numberOfTickets + reservationCreateDTO.getTicketAmount() > 5) {
                throw new RuntimeException("Reservation limit reached!");
            }
        }
        
        projection.setAvailableSeats(currentAvailableSeats - reservationCreateDTO.getTicketAmount());
        Reservation reservation = new Reservation(user, projection, reservationCreateDTO.getTicketAmount());
        return ReservationMapper.toDTO(reservationRepository.save(reservation));
    }

    @Override
    public Reservation getOne(Long id) {
        return reservationRepository.findByIdAndIsCanceledFalse(id)
                .orElseThrow(() -> new RuntimeException(String.format("Reservation with %d not found!", id)));
    }

    @Override
    @Transactional
    public void cancel(Long id) {
        Reservation reservation = getOne(id);
        reservation.setCanceled(true);
        int updatedSeats = reservation.getProjection().getAvailableSeats() + reservation.getTicketAmount();
        reservation.getProjection().setAvailableSeats(updatedSeats);
        reservationRepository.save(reservation);
    }

}
