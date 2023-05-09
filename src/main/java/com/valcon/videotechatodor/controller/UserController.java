package com.valcon.videotechatodor.controller;

import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.model.User;
import com.valcon.videotechatodor.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("registration")
    public void registration(@RequestBody UserDTO userDTO){
        userService.register(userDTO);
    }

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
}
