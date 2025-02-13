package net.weg.bibliotecaapi.DTO.Response;

import jakarta.validation.constraints.NotBlank;

public record AutorResponse(
        Integer id,
        String nome

) {
}
