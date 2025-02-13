package net.weg.bibliotecaapi.DTO.Response;

public record UsuarioResponse(
        Integer id,
        String cpf,
        String senha
) {
}
