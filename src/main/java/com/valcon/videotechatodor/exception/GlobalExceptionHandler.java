package com.valcon.videotechatodor.exception;

import com.valcon.videotechatodor.dto.ExceptionDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ExceptionDTO handleNotFoundException(EntityNotFoundException e) {
        return new ExceptionDTO(LocalDateTime.now(), e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({
            MovieActiveProjectionException.class,
            ProjectionInPastException.class,
            ProjectionOverlappingException.class,
            CancellationDeadlineException.class,
            SeatLimitException.class,
            TicketLimitException.class,
            SeatLimitException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ExceptionDTO handleBadRequestException(RuntimeException e) {
        return new ExceptionDTO(LocalDateTime.now(), e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public String handleMethodValidationFailure(final MethodArgumentNotValidException ex) {
        StringBuilder b = new StringBuilder();
        BindingResult results = ex.getBindingResult();
        for (FieldError e: results.getFieldErrors()) {
            b.append(e.getDefaultMessage());
        }
        return b.toString();
    }

}
