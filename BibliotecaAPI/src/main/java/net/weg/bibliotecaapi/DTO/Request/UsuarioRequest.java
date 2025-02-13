package net.weg.bibliotecaapi.DTO.Request;

import jakarta.validation.constraints.NotBlank;
import net.weg.bibliotecaapi.Entity.Usuario;

public record UsuarioRequest(
        @NotBlank String cpf,
        @NotBlank String senha
) {
    public Usuario toEntity() {
        return Usuario.builder()
                .cpf(cpf)
                .senha(senha)
                .build();
    }
}
