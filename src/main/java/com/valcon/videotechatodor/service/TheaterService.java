package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.TheaterDTO;
import com.valcon.videotechatodor.model.Theater;

import java.util.List;

public interface TheaterService {

    TheaterDTO getOneTheaterDTO(Long id);
    List<TheaterDTO> getAll();
    Theater getOneTheater(Long id);

}
