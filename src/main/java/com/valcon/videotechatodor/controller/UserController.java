package com.valcon.videotechatodor.controller;

import com.valcon.videotechatodor.dto.UserDTO;
import com.valcon.videotechatodor.model.User;
import com.valcon.videotechatodor.service.UserService;
import com.valcon.videotechatodor.utils.Role;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("registration")
    public ResponseEntity<?> registration(@RequestBody @Valid UserDTO userDTO){
        userService.register(userDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
}
