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
    public List<MovieDTO> getAll() {
        return movieRepository.findByIsDeletedFalse()
                .stream()
                .map(MovieMapper::toDTO)
                .toList();
    }

    @Override
    public void delete(Long id) {
        Movie movie = MovieMapper.toEntity(getOne(id));
        movie.setId(id);
        movie.setDeleted(true);
        movieRepository.save(movie);
    }

    @Override
    public MovieDTO create(MovieDTO movieDTO) {
        movieRepository.save(MovieMapper.toEntity(movieDTO));
        return movieDTO;
    }

    @Override
    public MovieDTO getOne(Long id) {
        return MovieMapper.toDTO(movieRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new RuntimeException("Movie with ID " + id + " does not exits")));
    }

    @Override
    public MovieDTO update(Long id, MovieDTO movieDTO) {
        Movie movie = MovieMapper.toEntity(getOne(id));
        movie.setId(id);
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
        if(movieDTO.getGenres() != null){
            movie.setGenres(movieDTO.getGenres());
        }
        movieRepository.save(movie);
        return MovieMapper.toDTO(movie);
    }

    @Override
    public MovieDTO updateAndReplace(Long id, MovieDTO movieDTO) {
        getOne(id);
        Movie updatedMovie = MovieMapper.toEntity(movieDTO);
        updatedMovie.setId(id);
        movieRepository.save(updatedMovie);
        return MovieMapper.toDTO(updatedMovie);
    }
}
