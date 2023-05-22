package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.MovieInfoDTO;
import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.model.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAll();
    void delete(Long id);
    MovieInfoDTO create(MovieInfoDTO movieDTO);
    MovieDTO getOneMovieDTO(Long id);
    Movie getOneMovie(Long id);
    MovieInfoDTO update(Long id, MovieInfoDTO movieDTO);
    MovieInfoDTO updateAndReplace(Long id, MovieInfoDTO movieDTO);

}
