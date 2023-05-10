package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.mapper.MovieMapper;
import com.valcon.videotechatodor.model.Movie;
import com.valcon.videotechatodor.repository.MovieRepository;
import com.valcon.videotechatodor.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> getAll() {
        return movieRepository.findByIsDeletedFalse();
    }

    @Override
    public void delete(Long id) {
        Movie movie = getOne(id);
        movie.setDeleted(true);
        movieRepository.save(movie);
    }

    @Override
    public Movie create(MovieDTO movieDTO) {
        return movieRepository.save(MovieMapper.toEntity(movieDTO));
    }

    @Override
    public Movie getOne(Long id) {
        return movieRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new RuntimeException("Movie with ID " + id + " does not exits"));
    }

    @Override
    public Movie update(Long id, MovieDTO movieDTO) {
        Movie movie = getOne(id);

        if(movieDTO.getName() != null){
            movie.setName(movieDTO.getName());
        }
        if(movieDTO.getDescription() != null){
            movie.setDescription(movieDTO.getDescription());
        }
        if(movieDTO.getDirector() != null){
            movie.setDirector(movieDTO.getDirector());
        }
        if(movieDTO.getLength() != 0){
            movie.setLength(movieDTO.getLength());
        }
        if(movieDTO.getGenre() != null){
            movie.setGenre(movieDTO.getGenre());
        }
        return movieRepository.save(movie);
    }

}
