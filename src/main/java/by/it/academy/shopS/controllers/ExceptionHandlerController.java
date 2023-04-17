package by.it.academy.shopS.controllers;

import by.it.academy.shopS.dto.ErrorResponse;
import by.it.academy.shopS.exceptions.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionHandlerController {
    @ExceptionHandler({UserNotFoundException.class, RuntimeException.class})
    public ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException exception) {
        log.warn("EXCEPTION: {}", exception.getMessage());
        return ResponseEntity.badRequest().body(new ErrorResponse(exception
                .getMessage(), LocalDateTime.now()));
    }
}
