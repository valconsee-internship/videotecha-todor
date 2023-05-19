package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.TheaterMovieDTO;
import com.valcon.videotechatodor.model.Movie;

public class TheaterMovieMapper {

    public static TheaterMovieDTO toDTO(Movie movie) {
        return new TheaterMovieDTO(movie.getName(), movie.getDescription(), movie.getDirector(), movie.getLength(), movie.getGenres());
    }

}
