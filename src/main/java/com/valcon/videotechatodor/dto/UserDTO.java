package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.Regex;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class UserDTO implements Serializable {

    @Pattern(regexp = Regex.USERNAME)
    private final String username;

    @Pattern(regexp = Regex.PASSWORD)
    private final String password;

    @Pattern(regexp = Regex.EMAIL)
    private final String email;


    public UserDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

}
