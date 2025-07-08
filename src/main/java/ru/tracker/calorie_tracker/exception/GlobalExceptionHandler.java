package ru.tracker.calorie_tracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handlerValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> messageError = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError ->
                messageError.put(fieldError.getField(), fieldError.getDefaultMessage())
        );
        return new ResponseEntity<>(messageError, HttpStatus.BAD_REQUEST);
    }
}
