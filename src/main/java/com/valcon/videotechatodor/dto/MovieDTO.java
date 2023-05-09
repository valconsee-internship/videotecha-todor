package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.Genre;

import java.io.Serializable;

public class MovieDTO implements Serializable {

    private final String name;

    private final String description;

    private final String director;

    private final int length;

    private final Genre genre;

    public MovieDTO(String name, String description, String director, int length, Genre genre) {
        this.name = name;
        this.description = description;
        this.director = director;
        this.length = length;
        this.genre = genre;
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

    public Genre getGenre() {
        return genre;
    }
}
