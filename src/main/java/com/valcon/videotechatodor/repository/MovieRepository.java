package com.valcon.videotechatodor.repository;

import com.valcon.videotechatodor.dto.ProjectionDTO;
import com.valcon.videotechatodor.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByIsDeletedFalse();
    Optional<Movie> findByIdAndIsDeletedFalse(Long id);
//    List<ProjectionDTO> findByProjectionId(Long id);
}
