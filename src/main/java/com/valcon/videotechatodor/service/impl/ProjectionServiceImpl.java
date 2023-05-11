package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.model.Projection;
import com.valcon.videotechatodor.repository.ProjectionRepository;
import com.valcon.videotechatodor.service.ProjectionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectionServiceImpl implements ProjectionService {

    private final ProjectionRepository projectionRepository;

    public ProjectionServiceImpl(ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

    @Override
    public List<Projection> getAll() {
        return projectionRepository.findAll();
    }

}
