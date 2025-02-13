package net.weg.bibliotecaapi.DTO.Response;

public record LivroResponse(
        Integer id,
        String nome,
        Integer quantidade,
        Integer autor_id
) {
}
