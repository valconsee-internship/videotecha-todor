package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.Genre;

import java.io.Serializable;
import java.util.List;

public class MovieDTO implements Serializable {

    private final String name;

    private final String description;

    private final String director;

    private final int length;

    private final List<Genre> genres;

    private final List<MovieProjectionDTO> projections;

    public MovieDTO(String name, String description, String director, int length, List<Genre> genres, List<MovieProjectionDTO> projections) {
        this.name = name;
        this.description = description;
        this.director = director;
        this.length = length;
        this.genres = genres;
        this.projections = projections;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public List<MovieProjectionDTO> getProjections() {
        return projections;
    }

}
