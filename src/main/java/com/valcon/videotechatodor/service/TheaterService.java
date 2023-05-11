package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.TheaterDTO;

import java.util.List;

public interface TheaterService {

    TheaterDTO getOne(Long id);
    List<TheaterDTO> getAll();

}
