package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.mapper.UserMapper;
import com.valcon.videotechatodor.model.User;
import com.valcon.videotechatodor.repository.UserRepository;
import com.valcon.videotechatodor.service.UserService;
import com.valcon.videotechatodor.utils.Role;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO register(UserDTO userDTO) {
        User newUser = UserMapper.toEntity(userDTO);
        newUser.setRole(Role.REGULAR_USER);
        userRepository.save(newUser);
        return userDTO;
    }

    @Override
    public List<UserDTO> getAll() {
        List<UserDTO> userDTOS = new ArrayList<>();
        for(User user: userRepository.findAll()){
            userDTOS.add(UserMapper.toDTO(user));
        }
        return userDTOS;
    }


}
