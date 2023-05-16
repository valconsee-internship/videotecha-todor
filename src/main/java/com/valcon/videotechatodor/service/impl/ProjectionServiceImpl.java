package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.ProjectionCreateDTO;
import com.valcon.videotechatodor.dto.ProjectionDTO;
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

import java.time.LocalDateTime;
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

    private static final String PROJECTION_NOT_FOUND = "Projection with ID %d  does not exits";

    private void isOverlapping(Projection projection){
        List<Projection> projections = projectionRepository.findByTheaterIdAndIsDeletedFalse(projection.getTheater().getId());
        boolean isOverlapping = projections.stream()
                .anyMatch(p -> isProjectionOverlapping(p, projection.getStartTime()));
        if (isOverlapping) {
            throw new RuntimeException("Projection overlapping");
        }
    }

    private static boolean isProjectionOverlapping(Projection projection, LocalDateTime newProjectionStartTime){
        return isAfterOrEqual(newProjectionStartTime, projection.getStartTime())
                && isBeforeOrEqual(newProjectionStartTime, projection.getEndTime());
    }

    private static boolean isAfterOrEqual(LocalDateTime date, LocalDateTime dateToCompare) {
        return date.isAfter(dateToCompare) || date.isEqual(dateToCompare);
    }

    private static boolean isBeforeOrEqual(LocalDateTime date, LocalDateTime dateToCompare) {
        return date.isBefore(dateToCompare) || date.isEqual(dateToCompare);
    }

    @Override
    public List<ProjectionDTO> getAll() {
        return projectionRepository.findByIsDeletedFalseAndStartTimeAfter(LocalDateTime.now())
                .stream()
                .map(ProjectionMapper::toDTO)
                .toList();
    }

    @Override
    public ProjectionDTO getOne(Long id) {
        return projectionRepository.findByIdAndIsDeletedFalseAndStartTimeAfter(id, LocalDateTime.now())
                .map(ProjectionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException(String.format(PROJECTION_NOT_FOUND, id)));
    }

    @Transactional
    @Override
    public ProjectionDTO create(ProjectionCreateDTO projectionDTO) {
        Projection projection = new Projection();
        Movie movie = movieService.getOneMovie(projectionDTO.getMovieId());
        projection.setMovie(movie);
        Theater theater = theaterService.getOneTheater(projectionDTO.getTheaterId());
        projection.setTheater(theater);
        if (isBeforeOrEqual(projectionDTO.getStartTime(), LocalDateTime.now())) {
            throw new RuntimeException("Cannot create projection in the past!");
        }
        projection.setStartTime(projectionDTO.getStartTime());
        projection.setTicketPrice(projectionDTO.getTicketPrice());
        isOverlapping(projection);
        return ProjectionMapper.toDTO(projectionRepository.save(projection));
    }

    @Override
    public void delete(Long id) {
        Projection projection = projectionRepository.findByIdAndIsDeletedFalseAndStartTimeAfter(id, LocalDateTime.now())
                .orElseThrow(() -> new RuntimeException(String.format(PROJECTION_NOT_FOUND, id)));
        projection.setDeleted(true);
        projectionRepository.save(projection);
    }

}
