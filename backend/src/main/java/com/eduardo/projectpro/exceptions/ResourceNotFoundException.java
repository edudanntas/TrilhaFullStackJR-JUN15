package com.eduardo.projectpro.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.Instant;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public Instant getTimestamp() {
        return Instant.now();
    }

    public Integer getStatusCode() {
        return 404;
    }

    public String getError() {
        return HttpStatus.NOT_FOUND.getReasonPhrase();
    }
}
