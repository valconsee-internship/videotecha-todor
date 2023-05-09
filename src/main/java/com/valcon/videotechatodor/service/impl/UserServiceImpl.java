package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.mapper.Mapper;
import com.valcon.videotechatodor.model.User;
import com.valcon.videotechatodor.repository.UserRepository;
import com.valcon.videotechatodor.service.UserService;
import com.valcon.videotechatodor.utils.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(UserDTO userDTO) {
        User newUser = Mapper.toUserEntity(userDTO);
        newUser.setRole(Role.REGULAR_USER);
        userRepository.save(newUser);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }


}
