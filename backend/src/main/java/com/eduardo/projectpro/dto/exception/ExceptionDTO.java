package com.eduardo.projectpro.dto.exception;

import java.time.Instant;

public record ExceptionDTO(
        Instant timestamp,
        Integer status,
        String error,
        String message
) {
}
