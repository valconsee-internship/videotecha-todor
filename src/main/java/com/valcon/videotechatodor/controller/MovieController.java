package com.valcon.videotechatodor.controller;

import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.model.Movie;
import com.valcon.videotechatodor.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getAllMovies(){
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public Movie getOneMovie(@PathVariable Long id){
        return movieService.getOne(id);
    }

    @PostMapping
    public Movie createMovie(@RequestBody MovieDTO movieDTO){
        return movieService.create(movieDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.delete(id);
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
       return movieService.update(id, movieDTO);
    }
}
