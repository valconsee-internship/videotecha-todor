package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.ReservationDTO;
import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.model.User;

import java.util.List;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    List<UserDTO> getAll();
    User getOneUser(Long id);
    UserDTO getOneUserDTO(Long id);
    List<ReservationDTO> getUsersReservations(Long id);

}
