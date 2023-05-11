package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.MovieDTO;
import java.util.List;

public interface MovieService {

    List<MovieDTO> getAll();
    void delete(Long id);
    MovieDTO create(MovieDTO movieDTO);
    MovieDTO getOne(Long id);
    MovieDTO update(Long id, MovieDTO movieDTO);
    MovieDTO updateAndReplace(Long id, MovieDTO movieDTO);

}
