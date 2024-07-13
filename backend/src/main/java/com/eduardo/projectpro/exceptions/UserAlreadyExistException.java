package com.eduardo.projectpro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }

    public Integer getStatusCode() {
        return 409;
    }

    public String getError() {
        return HttpStatus.CONFLICT.getReasonPhrase();
    }

    public Instant getTimestamp() {
        return Instant.now();
    }
}
