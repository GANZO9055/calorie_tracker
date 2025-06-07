package ru.tracker.calorie_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> notFound(NotFoundException notFoundException) {
        return new ResponseEntity<>(
                Map.of(
                        "time", LocalDateTime.now(),
                        "status", "404",
                        "error", notFoundException.getMessage()
                ),
                HttpStatus.NOT_FOUND
        );
    }
}
