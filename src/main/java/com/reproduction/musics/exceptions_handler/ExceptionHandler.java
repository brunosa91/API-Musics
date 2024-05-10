package com.reproduction.musics.exceptions_handler;

import com.reproduction.musics.exceptions_handler.exceptions.ListNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(ListNotFound.class)
    public ResponseEntity<StandardError> resourceNotFound(ListNotFound listNotFound) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError standardError = new StandardError(Instant.now(), httpStatus.value(), listNotFound.getMessage());
        return ResponseEntity.status(httpStatus).body(standardError);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity FixError400(MethodArgumentNotValidException e) {
        var err = e.getFieldErrors();
        return ResponseEntity.badRequest().body(err.stream().map(DataErrorValidation::new).toList());
    }
    private record DataErrorValidation(String field, String message) {
        public DataErrorValidation(FieldError err) {
            this(err.getField(), err.getDefaultMessage());
        }
    }

}
