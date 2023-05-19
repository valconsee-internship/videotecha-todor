package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.MovieInfoDTO;
import com.valcon.videotechatodor.model.Movie;

public class MovieInfoMapper {

    public static MovieInfoDTO toDTO(Movie movie) {
        return new MovieInfoDTO(movie.getName(), movie.getDescription(),
                movie.getDirector(), movie.getLength(), movie.getGenres());
    }

}
