package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.model.Movie;

public class MovieMapper {
    public static Movie toEntity(MovieDTO movieDTO) {
        return new Movie(movieDTO.getName(), movieDTO.getDescription(), movieDTO.getDirector(), movieDTO.getLength(), movieDTO.getGenres());
    }

    public static MovieDTO toDTO(Movie movie){
        return new MovieDTO(movie.getName(), movie.getDescription(), movie.getDirector(), movie.getLength(), movie.getGenres());
    }

    private MovieMapper() {
    }
}
