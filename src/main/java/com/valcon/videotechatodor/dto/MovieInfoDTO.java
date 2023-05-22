package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

public class MovieInfoDTO implements Serializable {

    @Length(min = 1)
    private final String name;

    @Length(min = 3, max = 255)
    private final String description;

    @Length(min = 3, max = 255)
    private final String director;

    @Min(2)
    @Max(300)
    private final int length;

    @NotEmpty
    private final List<Genre> genres;

    public MovieInfoDTO(String name, String description, String director, int length, List<Genre> genres) {
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

    public int getLength() {
        return length;
    }

    public List<Genre> getGenres() {
        return genres;
    }

}
