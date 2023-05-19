package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.ProjectionCreateDTO;
import com.valcon.videotechatodor.dto.ProjectionDTO;
import com.valcon.videotechatodor.model.Projection;

import java.util.List;

public interface ProjectionService {

    List<ProjectionDTO> getAll();
    ProjectionDTO getOneProjectionDTO(Long id);
    Projection getOneProjection(Long id);
    ProjectionDTO create(ProjectionCreateDTO projectionCreateDTO);
    void delete(Long id);

}
