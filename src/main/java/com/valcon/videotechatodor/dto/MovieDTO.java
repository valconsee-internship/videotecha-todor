package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.Genre;

import java.io.Serializable;
import java.util.List;

public class MovieDTO implements Serializable {

    private final String name;

    private final String description;

    private final String director;

    private final Double length;

    private final List<Genre> genres;

    public MovieDTO(String name, String description, String director, Double length, List<Genre> genres) {
        this.name = name;
        this.description = description;
        this.director = director;
        this.length = length;
        this.genres = genres;
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

    public Double getLength() {
        return length;
    }

    public List<Genre> getGenres() {
        return genres;
    }

}
