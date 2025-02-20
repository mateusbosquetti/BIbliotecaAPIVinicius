package net.weg.bibliotecaapi.DTO.Response;

import java.time.Instant;

public record ErrorResponseDTO (
        String message, Instant instant
) {
}
