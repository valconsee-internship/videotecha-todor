package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.model.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAll();
    void delete(Long id);
    MovieDTO create(MovieDTO movieDTO);
    MovieDTO getOneMovieDTO(Long id);
    Movie getOneMovie(Long id);
    MovieDTO update(Long id, MovieDTO movieDTO);
    MovieDTO updateAndReplace(Long id, MovieDTO movieDTO);

}
