package com.valcon.videotechatodor.mapper;

import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.model.User;

public class UserMapper {

    public static User toEntity(UserDTO userDTO) {
        return new User(userDTO.getUsername(), userDTO.getPassword(), userDTO.getEmail());
    }

    public static UserDTO toDTO(User user){
        return new UserDTO(user.getUsername(), user.getPassword(), user.getEmail());
    }

    private UserMapper() {
    }

}
