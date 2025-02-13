package net.weg.bibliotecaapi.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import net.weg.bibliotecaapi.Entity.Autor;

public record AutorRequest(
        @NotBlank String nome
) {
    public Autor toEntity() {
        return Autor.builder()
                .nome(this.nome)
                .build();
    }
}
