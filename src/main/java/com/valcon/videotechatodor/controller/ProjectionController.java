package com.valcon.videotechatodor.controller;

import com.valcon.videotechatodor.model.Projection;
import com.valcon.videotechatodor.service.ProjectionService;
import org.springframework.web.bind.annotation.GetMapping;
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
    public List<Projection> getAll(){
        return projectionService.getAll();
    }

}
