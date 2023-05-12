package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.ProjectionCreateDTO;
import com.valcon.videotechatodor.dto.ProjectionDTO;
import com.valcon.videotechatodor.mapper.MovieMapper;
import com.valcon.videotechatodor.mapper.ProjectionMapper;
import com.valcon.videotechatodor.mapper.TheaterMapper;
import com.valcon.videotechatodor.model.Movie;
import com.valcon.videotechatodor.model.Projection;
import com.valcon.videotechatodor.model.Theater;
import com.valcon.videotechatodor.repository.ProjectionRepository;
import com.valcon.videotechatodor.service.MovieService;
import com.valcon.videotechatodor.service.ProjectionService;
import com.valcon.videotechatodor.service.TheaterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionRepository projectionRepository;

    private final MovieService movieService;

    private final TheaterService theaterService;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository, MovieService movieService, TheaterService theaterService) {
        this.projectionRepository = projectionRepository;
        this.movieService = movieService;
        this.theaterService = theaterService;
    }


    @Override
    public List<ProjectionDTO> getAll() {
        return projectionRepository.findAll()
                .stream()
                .map(ProjectionMapper::toDTO)
                .toList();
    }

    @Override
    public ProjectionDTO create(ProjectionCreateDTO projectionDTO) {
        Projection projection = new Projection();
        Movie movie = MovieMapper.toEntity(movieService.getOne(projectionDTO.getMovieId()));
        movie.setId(projectionDTO.getMovieId());
        projection.setMovie(movie);
        Theater theater = TheaterMapper.toEntity(theaterService.getOne(projectionDTO.getTheaterId()));
        theater.setId(projectionDTO.getTheaterId());
        projection.setTheater(theater);
        projection.setStartTime(projectionDTO.getStartTime());
        projection.setTicketPrice(projectionDTO.getTicketPrice());
        return ProjectionMapper.toDTO(projectionRepository.save(projection));
    }

}
