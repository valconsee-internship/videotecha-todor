package com.valcon.videotechatodor.repository;

import com.valcon.videotechatodor.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {

    List<Projection> findByIsDeletedFalseAndStartTimeAfter(LocalDateTime now);
    Optional<Projection> findByIdAndIsDeletedFalseAndStartTimeAfter(Long id, LocalDateTime now);

    List<Projection> findByTheaterIdAndIsDeletedFalse(Long theaterId);

}
