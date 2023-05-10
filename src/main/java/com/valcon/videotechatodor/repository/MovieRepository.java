package com.valcon.videotechatodor.repository;

import com.valcon.videotechatodor.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findByIsDeletedFalse();
    Optional<Movie> findByIdAndIsDeletedFalse(Long id);
}
