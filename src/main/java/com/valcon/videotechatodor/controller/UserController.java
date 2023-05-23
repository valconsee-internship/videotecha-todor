package com.valcon.videotechatodor.controller;

import com.valcon.videotechatodor.dto.ReservationDTO;
import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("registration")
    public UserDTO registration(@RequestBody @Valid UserDTO userDTO) {
        return userService.register(userDTO);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public UserDTO getOneUser(@PathVariable Long id) {
        return userService.getOneUserDTO(id);
    }

    @GetMapping("{id}/reservations")
    public List<ReservationDTO> usersReservations(@PathVariable Long id) {
        return userService.getUsersReservations(id);
    }

}
