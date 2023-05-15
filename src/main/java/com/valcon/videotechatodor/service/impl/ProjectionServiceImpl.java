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
import org.springframework.transaction.annotation.Transactional;

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
        return projectionRepository.findByIsDeletedFalse()
                .stream()
                .map(ProjectionMapper::toDTO)
                .toList();
    }

    @Override
    public ProjectionDTO getOne(Long id) {
        return projectionRepository.findByIdAndIsDeletedFalse(id)
                .map(ProjectionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException());
    }

    @Transactional
    @Override
    public ProjectionDTO create(ProjectionCreateDTO projectionDTO) {
        Projection projection = new Projection();
        Movie movie = movieService.getOneMovie(projectionDTO.getMovieId());
        projection.setMovie(movie);
        Theater theater = TheaterMapper.toEntity(theaterService.getOne(projectionDTO.getTheaterId()));
        theater.setId(projectionDTO.getTheaterId());
        projection.setTheater(theater);
        projection.setStartTime(projectionDTO.getStartTime());
        projection.setTicketPrice(projectionDTO.getTicketPrice());
        return ProjectionMapper.toDTO(projectionRepository.save(projection));
    }

    @Override
    public void delete(Long id) {
        Projection projection = projectionRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Projection with ID " + id + " does not exits"));
        projection.setDeleted(true);
        projectionRepository.save(projection);
    }

}
