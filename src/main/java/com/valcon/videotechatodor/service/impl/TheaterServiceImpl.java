package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.TheaterDTO;
import com.valcon.videotechatodor.mapper.TheaterMapper;
import com.valcon.videotechatodor.model.Theater;
import com.valcon.videotechatodor.repository.TheaterRepository;
import com.valcon.videotechatodor.service.TheaterService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;

    public TheaterServiceImpl(TheaterRepository theaterRepository) {
        this.theaterRepository = theaterRepository;
    }

    @Override
    public TheaterDTO getOneTheaterDTO(Long id) {
        return TheaterMapper.toDTO(theaterRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Theater with ID " + id + " does not exits"))
        );
    }

    @Override
    public List<TheaterDTO> getAll() {
        List<Theater> theaters = theaterRepository.findAll();
        List<TheaterDTO> theaterDTOS = new ArrayList<>();
        for (Theater theater : theaters) {
            theaterDTOS.add(TheaterMapper.toDTO(theater));
        }
        return theaterDTOS;
    }

    @Override
    public Theater getOneTheater(Long id) {
        return theaterRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Theater with ID " + id + " does not exits"));
    }

}
