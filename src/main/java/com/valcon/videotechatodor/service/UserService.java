package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO register(UserDTO userDTO);
    List<UserDTO> getAll();

}
