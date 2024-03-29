package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.MovieCreateDTO;
import com.valcon.videotechatodor.dto.MovieDTO;
import com.valcon.videotechatodor.exception.BusinessLogicException;
import com.valcon.videotechatodor.mapper.MovieMapper;
import com.valcon.videotechatodor.model.Movie;
import com.valcon.videotechatodor.model.Projection;
import com.valcon.videotechatodor.repository.MovieRepository;
import com.valcon.videotechatodor.service.MovieService;
import com.valcon.videotechatodor.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    private static String HAS_PROJECTION_ERROR = "Movie has active projections";
    private static String MOVIE_NOT_EXIST = "Movie with id %d does not exist";

    private static boolean hasActiveProjections(Movie movie) {
        List<Projection> projections =  movie.getProjections()
                .stream()
                .filter(p -> !p.isDeleted() && !hasPassed(p))
                .toList();
        return !projections.isEmpty();
    }

    private static boolean hasPassed(Projection projection) {
        LocalDateTime endTIme = projection.getStartTime().plusMinutes(projection.getMovie().getLength());
        return endTIme.isBefore(LocalDateTime.now());
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
        Movie movie = movieRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(MOVIE_NOT_EXIST, id)));
        if (hasActiveProjections(movie)) {
            throw new BusinessLogicException(HAS_PROJECTION_ERROR);
        }
        movie.setDeleted(true);
        movieRepository.save(movie);
    }

    @Override
    public MovieDTO create(MovieCreateDTO movieCreateDTO) {
        Movie movie = MovieMapper.toEntity(movieCreateDTO);
        return MovieMapper.toDTO(movieRepository.save(movie));
    }

    @Override
        public MovieDTO getOneMovieDTO(Long id) {
        return movieRepository.findByIdAndIsDeletedFalse(id)
                .map(MovieMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(MOVIE_NOT_EXIST, id)));
    }

    @Override
    public Movie getOneMovie(Long id) {
        return movieRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(MOVIE_NOT_EXIST, id)));
    }

    @Override
    public MovieDTO update(Long id, MovieCreateDTO movieDTO) {
        Movie movie = getOneMovie(id);

        if (hasActiveProjections(movie)) {
            throw new BusinessLogicException(HAS_PROJECTION_ERROR);
        }
        if (movieDTO.getName() != null) {
            movie.setName(movieDTO.getName());
        }
        if (movieDTO.getDescription() != null) {
            movie.setDescription(movieDTO.getDescription());
        }
        if (movieDTO.getDirector() != null) {
            movie.setDirector(movieDTO.getDirector());
        }
        if (movieDTO.getLength() != 0) {
            movie.setLength(movieDTO.getLength());
        }
        if (movieDTO.getGenres() != null) {
            movie.setGenres(movieDTO.getGenres());
        }
        movieRepository.save(movie);
        return MovieMapper.toDTO(movie);
    }

    @Override
    public MovieDTO updateAndReplace(Long id, MovieCreateDTO movieDTO) {
        Movie movie = getOneMovie(id);
        if (hasActiveProjections(movie)) {
            throw new BusinessLogicException(HAS_PROJECTION_ERROR);
        }
        movieRepository.save(movie);
        return MovieMapper.toDTO(movie);
    }

}
