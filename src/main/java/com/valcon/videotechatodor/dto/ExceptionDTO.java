package com.valcon.videotechatodor.dto;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ExceptionDTO implements Serializable {

    private final LocalDateTime exceptionTime;

    private final String message;

    private final HttpStatus httpStatus;

    public ExceptionDTO(LocalDateTime exceptionTime, String message, HttpStatus httpStatus) {
        this.exceptionTime = exceptionTime;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public LocalDateTime getExceptionTime() {
        return exceptionTime;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
