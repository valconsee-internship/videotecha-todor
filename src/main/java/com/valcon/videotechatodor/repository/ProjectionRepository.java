package com.valcon.videotechatodor.repository;

import com.valcon.videotechatodor.model.Projection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProjectionRepository extends JpaRepository<Projection, Long> {

    List<Projection> findByIsDeletedFalse();
    Optional<Projection> findByIdAndIsDeletedFalse(Long id);

}
