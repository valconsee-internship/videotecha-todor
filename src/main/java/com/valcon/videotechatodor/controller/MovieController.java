package com.valcon.videotechatodor.controller;

import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.service.MovieService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<MovieDTO> getAllMovies(){
        return movieService.getAll();
    }

    @GetMapping("/{id}")
    public MovieDTO getOneMovie(@PathVariable Long id){
        return movieService.getOneMovieDTO(id);
    }

    @PostMapping
    public MovieDTO createMovie(@RequestBody MovieDTO movieDTO){
        return movieService.create(movieDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id){
        movieService.delete(id);
    }

    @PatchMapping("/{id}")
    public MovieDTO updateMovie(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
       return movieService.update(id, movieDTO);
    }

    @PutMapping("/{id}")
    public MovieDTO updateMovieAndReplace(@PathVariable Long id, @RequestBody MovieDTO movieDTO){
        return movieService.updateAndReplace(id, movieDTO);
    }

}
