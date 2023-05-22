package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.Genre;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.List;

public class MovieInfoDTO implements Serializable {

    @Length(min = 1, max = 255, message = "Movie name must be between 1 and 255 characters. ")
    private final String name;

    @Length(min = 3, max = 255, message = "Description must be between 3 and 255 characters. ")
    private final String description;

    @Length(min = 3, max = 255, message = "Name of director must be between 3 and 255 characters. ")
    private final String director;

    @Min(value = 2, message = "Movie length cannot be less than 2 minutes. ")
    @Max(value = 300, message = "Movie length cannot be greater than 300 minutes. ")
    private final int length;

    @NotEmpty(message = "Movie need to have at least one genre. ")
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
