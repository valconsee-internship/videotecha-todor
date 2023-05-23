package com.valcon.videotechatodor.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExceptionDTO implements Serializable {

    private final LocalDateTime exceptionTime;

    private final String message;

    public ExceptionDTO(LocalDateTime exceptionTime, String message) {
        this.exceptionTime = exceptionTime;
        this.message = message;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }

    public String getMessage() {
        return message;
    }

}
