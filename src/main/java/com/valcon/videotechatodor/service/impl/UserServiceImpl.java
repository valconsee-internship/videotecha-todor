package com.valcon.videotechatodor.service.impl;

import com.valcon.videotechatodor.dto.ReservationDTO;
import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.mapper.ReservationMapper;
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

    private static final String USER_NOT_FOUND = "User with id %d does not exist";

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
        for (User user : userRepository.findAll()) {
            userDTOS.add(UserMapper.toDTO(user));
        }
        return userDTOS;
    }

    @Override
    public User getOneUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(USER_NOT_FOUND, id)));
    }

    @Override
    public UserDTO getOneUserDTO(Long id) {
        return userRepository.findById(id)
                .map(UserMapper::toDTO)
                .orElseThrow(() -> new RuntimeException(String.format(USER_NOT_FOUND, id)));
    }

    @Override
    public List<ReservationDTO> getUsersReservations(Long id) {
        User user = getOneUser(id);
        return user.getReservations()
                .stream()
                .map(ReservationMapper::toDTO)
                .toList();
    }

}
