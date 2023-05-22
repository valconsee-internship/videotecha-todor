package com.valcon.videotechatodor.dto;

import com.valcon.videotechatodor.utils.Regex;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;

public class UserDTO implements Serializable {

    @Pattern(regexp = Regex.USERNAME, message = "Username can contain only letters and '_' symbol and must be between 3 and 21 characters long")
    private final String username;

    @Pattern(regexp = Regex.PASSWORD, message = """
            Password must contain at least one number, one lowercase letter,
            one uppercase letter, one special character and must be between 8 and 255 characters
            """)
    private final String password;

    @Pattern(regexp = Regex.EMAIL, message = "Invalid email address")
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
