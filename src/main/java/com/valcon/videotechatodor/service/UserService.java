package com.valcon.videotechatodor.service;

import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.model.User;

import java.util.List;

public interface UserService {
    void register(UserDTO userDTO);
    List<User> getAll();
}
