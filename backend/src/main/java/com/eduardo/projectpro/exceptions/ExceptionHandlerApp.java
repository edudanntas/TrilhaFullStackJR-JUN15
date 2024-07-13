package com.eduardo.projectpro.exceptions;

import com.eduardo.projectpro.dto.exception.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerApp {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleResourceNotFoundException(ResourceNotFoundException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                e.getTimestamp(),
                e.getStatusCode(),
                e.getError(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<ExceptionDTO> handleUserAlreadyExistException(UserAlreadyExistException e) {
        ExceptionDTO exceptionDTO = new ExceptionDTO(
                e.getTimestamp(),
                e.getStatusCode(),
                e.getError(),
                e.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
    }
}
