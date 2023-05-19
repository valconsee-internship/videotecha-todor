package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.dto.MovieInfoDTO;
import com.valcon.videotechatodor.model.Movie;

public class MovieMapper {
    public static Movie toEntity(MovieInfoDTO movieInfoDTO) {
        return new Movie(movieInfoDTO.getName(), movieInfoDTO.getDescription(), movieInfoDTO.getDirector(),
                movieInfoDTO.getLength(), movieInfoDTO.getGenres());
    }

    public static MovieDTO toDTO(Movie movie) {
        return new MovieDTO(movie.getName(), movie.getDescription(), movie.getDirector(), movie.getLength(), movie.getGenres(),
                MovieProjectionMapper.toDTO(movie.getProjections()));
    }

    private MovieMapper() {
    }

}
