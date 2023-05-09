package com.valcon.videotechatodor.repository;

import com.valcon.videotechatodor.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
