package com.valcon.videotechatodor.controller;

import com.valcon.videotechatodor.dto.TheaterDTO;
import com.valcon.videotechatodor.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/theaters")
public class TheaterController {

    private final TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @GetMapping
    public List<TheaterDTO> getAll(){
        return theaterService.getAll();
    }

    @GetMapping("/{id}")
    public TheaterDTO getOne(@PathVariable Long id){
        return theaterService.getOne(id);
    }

}
