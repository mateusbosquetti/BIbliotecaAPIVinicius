package net.weg.bibliotecaapi.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import net.weg.bibliotecaapi.Entity.Livro;

public record LivroRequest(
        @NotBlank String nome,
        @NotNull Integer quantidade,
        @NotNull Integer autor_id

) {
}
