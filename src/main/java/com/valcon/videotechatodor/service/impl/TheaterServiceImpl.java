package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.TheaterDTO;
import com.valcon.videotechatodor.exception.ResourceNotFoundException;
import com.valcon.videotechatodor.mapper.TheaterMapper;
import com.valcon.videotechatodor.model.Theater;
import com.valcon.videotechatodor.repository.TheaterRepository;
import com.valcon.videotechatodor.service.TheaterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    private static final String THEATER_NOT_FOUND = "Theater with id %d does not exist";

    @Override
    public TheaterDTO getOneTheaterDTO(Long id) {
        return theaterRepository.findById(id)
                .map(TheaterMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(THEATER_NOT_FOUND, id)));
    }

    @Override
    public List<TheaterDTO> getAll() {
        return theaterRepository.findAll()
                .stream()
                .map(TheaterMapper::toDTO)
                .toList();
    }

    @Override
    public Theater getOneTheater(Long id) {
        return theaterRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException(String.format(THEATER_NOT_FOUND, id)));
    }

}
