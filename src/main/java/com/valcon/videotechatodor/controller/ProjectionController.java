package com.valcon.videotechatodor.controller;

import com.valcon.videotechatodor.dto.ProjectionCreateDTO;
import com.valcon.videotechatodor.dto.ProjectionDTO;
import com.valcon.videotechatodor.model.Projection;
import com.valcon.videotechatodor.service.ProjectionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/projections")
public class ProjectionController {

    private final ProjectionService projectionService;

    public ProjectionController(ProjectionService projectionService) {
        this.projectionService = projectionService;
    }

    @GetMapping
    public List<ProjectionDTO> getAll(){
        return projectionService.getAll();
    }

    @PostMapping
    public ProjectionDTO createProjection(@RequestBody ProjectionCreateDTO projection){
        return projectionService.create(projection);
    }

}
