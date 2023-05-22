package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.ReservationCreateDTO;
import com.valcon.videotechatodor.dto.ReservationDTO;
import com.valcon.videotechatodor.exception.CancellationDeadlineException;
import com.valcon.videotechatodor.exception.ReservationLimitException;
import com.valcon.videotechatodor.exception.SeatLimitException;
import com.valcon.videotechatodor.exception.TicketLimitException;
import com.valcon.videotechatodor.mapper.ReservationMapper;
import com.valcon.videotechatodor.model.Projection;
import com.valcon.videotechatodor.model.Reservation;
import com.valcon.videotechatodor.model.User;
import com.valcon.videotechatodor.repository.ReservationRepository;
import com.valcon.videotechatodor.service.ProjectionService;
import com.valcon.videotechatodor.service.ReservationService;
import com.valcon.videotechatodor.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    private final int TICKET_LIMIT = 5;
    private final int CANCELLATION_DEADLINE = 2;

    @Override
    @Transactional
    public ReservationDTO create(ReservationCreateDTO reservationCreateDTO) {
        User user = userService.getOneUser(reservationCreateDTO.getUserId());
        Projection projection = projectionService.getOneProjection(reservationCreateDTO.getProjectionId());
        boolean isLessOrEqualThenFive = reservationCreateDTO.getNumberOfTicket() <= TICKET_LIMIT;
        if(!isLessOrEqualThenFive) {
            throw new TicketLimitException("You cannot buy more than 5 tickets");
        }

        int currentAvailableSeats = projection.getAvailableSeats();
        if (currentAvailableSeats < reservationCreateDTO.getNumberOfTicket()) {
            throw new SeatLimitException("No available seats");
        }

        List<Reservation> userReservations = reservationRepository.findAllByUserIdAndProjectionIdAndIsCanceledFalse(reservationCreateDTO.getUserId(), reservationCreateDTO.getProjectionId());
        if (!userReservations.isEmpty()) {
            int numberOfTickets = userReservations
                    .stream()
                    .mapToInt(Reservation::getNumberOfTickets)
                    .sum();
            if (numberOfTickets + reservationCreateDTO.getNumberOfTicket() > TICKET_LIMIT) {
                throw new ReservationLimitException("Reservation limit reached!");
            }
        }
        
        projection.setAvailableSeats(currentAvailableSeats - reservationCreateDTO.getNumberOfTicket());
        Reservation reservation = new Reservation(user, projection, reservationCreateDTO.getNumberOfTicket());
        return ReservationMapper.toDTO(reservationRepository.save(reservation));
    }

    @Override
    public Reservation getOne(Long id) {
        return reservationRepository.findByIdAndIsCanceledFalse(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Reservation with %d does not exist!", id)));
    }

    @Override
    @Transactional
    public void cancel(Long id) {
        Reservation reservation = getOne(id);
        if (LocalDateTime.now().isAfter(reservation.getProjection().getStartTime().minusHours(CANCELLATION_DEADLINE))) {
            throw new CancellationDeadlineException("Cannot cancel reservation 2 hours before projection");
        }
        reservation.setCanceled(true);
        int updatedSeats = reservation.getProjection().getAvailableSeats() + reservation.getNumberOfTickets();
        reservation.getProjection().setAvailableSeats(updatedSeats);
        reservationRepository.save(reservation);
    }

}
