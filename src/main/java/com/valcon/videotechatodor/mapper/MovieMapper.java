package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.dto.MovieCreateDTO;
import com.valcon.videotechatodor.model.Movie;

public class MovieMapper {
    public static Movie toEntity(MovieCreateDTO movieCreateDTO) {
        return new Movie(movieCreateDTO.getName(), movieCreateDTO.getDescription(), movieCreateDTO.getDirector(),
                movieCreateDTO.getLength(), movieCreateDTO.getGenres());
    }

    public static MovieDTO toDTO(Movie movie) {
        return new MovieDTO(movie.getId(), movie.getName(), movie.getDescription(), movie.getDirector(), movie.getLength(), movie.getGenres(),
                MovieProjectionMapper.toDTO(movie.getProjections()));
    }

    private MovieMapper() {
    }

}
