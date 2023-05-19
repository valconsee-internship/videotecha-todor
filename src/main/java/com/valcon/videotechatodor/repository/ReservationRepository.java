package com.valcon.videotechatodor.repository;

import com.valcon.videotechatodor.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByUserIdAndProjectionIdAndIsCanceledFalse(Long userId, Long projectionId);
    Optional<Reservation> findByIdAndIsCanceledFalse(Long id);

}
