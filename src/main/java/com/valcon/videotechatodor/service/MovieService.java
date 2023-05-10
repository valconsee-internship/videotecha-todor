package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> getAll();
    void delete(Long id);
    Movie create(MovieDTO movieDTO);
    Movie getOne(Long id);
    Movie update(Long id, MovieDTO movieDTO);
}
