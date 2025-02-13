package net.weg.bibliotecaapi.Service;

import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.LivroRequest;
import net.weg.bibliotecaapi.DTO.Response.LivroResponse;
import net.weg.bibliotecaapi.Entity.Livro;
import net.weg.bibliotecaapi.Entity.Usuario;
import net.weg.bibliotecaapi.Repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class LivroService {

    private LivroRepository repository;
    private AutorService autorService;

    public LivroResponse adicionarLivro (LivroRequest LivroRequest) {
        Livro livro = repository.save(toEntity(LivroRequest));
        return livro.toDTO();
    }

    private Livro toEntity(LivroRequest livroRequest) {
        return Livro.builder()
                .nome(livroRequest.nome())
                .quantidade(livroRequest.quantidade())
                .autor(autorService.buscarAutorsId(livroRequest.autor_id()))
                .build();
    }

    public List<LivroResponse> buscarLivros () {
        return repository.findAll().stream().map(Livro::toDTO).collect(Collectors.toList());
    }

    public Livro buscarLivroID (Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
