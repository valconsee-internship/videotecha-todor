package com.valcon.videotechatodor.repository;

import com.valcon.videotechatodor.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByUserId(Long id);

}
