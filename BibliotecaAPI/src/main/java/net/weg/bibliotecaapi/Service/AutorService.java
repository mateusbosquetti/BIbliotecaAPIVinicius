package net.weg.bibliotecaapi.Service;

import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.AutorRequest;
import net.weg.bibliotecaapi.DTO.Response.AutorResponse;
import net.weg.bibliotecaapi.Entity.Autor;
import net.weg.bibliotecaapi.Repository.AutorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AutorService {

    private AutorRepository repository;

    public AutorResponse adicionarAutor(AutorRequest autorRequest) {
        Autor autor = repository.save(autorRequest.toEntity());
        return autor.toDTO();
    }

    public List<AutorResponse> buscarAutors() {
        return repository.findAll().stream().map(Autor::toDTO).collect(Collectors.toList());
    }

    public AutorResponse buscarAutorResponseId(Integer id) {
        Autor autor = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return autor.toDTO();
    }

    public void deletarAutor(Integer id) {
        buscarAutorResponseId(id);
        repository.deleteById(id);
    }

    public AutorResponse atualizarAutor(AutorRequest autorRequest, Integer id) {
        buscarAutorResponseId(id);

        Autor autor = autorRequest.toEntity();
        autor.setId(id);
        repository.save(autor);
        return autor.toDTO();
    }


    public Autor buscarAutorsId(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }


}
