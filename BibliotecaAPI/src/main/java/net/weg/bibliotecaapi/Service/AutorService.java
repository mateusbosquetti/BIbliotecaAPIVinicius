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

    /**
     * Método para adicionar um Autor novo
     * @param autorRequest
     * @return DTO de resposta do Autor
     */
    public AutorResponse adicionarAutor(AutorRequest autorRequest) {
        Autor autor = repository.save(autorRequest.toEntity());
        return autor.toDTO();
    }

    /**
     * Método para listar todos os Autores
     * @return Lista de DTO's de response do Autor
     */
    public List<AutorResponse> buscarAutors() {
        return repository.findAll().stream().map(Autor::toDTO).collect(Collectors.toList());
    }

    /**
     * Método para buscar um Autor especifico
     * @param id
     * @return DTO de resposta do Autor encontrado
     */
    public AutorResponse buscarAutorResponseId(Integer id) {
        Autor autor = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return autor.toDTO();
    }

    /**
     * Método para deletar um Autor especifico
     * @param id
     * @return void
     */
    public void deletarAutor(Integer id) {
        buscarAutorResponseId(id);
        repository.deleteById(id);
    }

    /**
     * Método para editar um Autor especifico
     * @param autorRequest
     * @param id
     * @return DTO de resposta do Autor encontrado
     */
    public AutorResponse atualizarAutor(AutorRequest autorRequest, Integer id) {
        buscarAutorResponseId(id);

        Autor autor = autorRequest.toEntity();
        autor.setId(id);
        repository.save(autor);
        return autor.toDTO();
    }

    /**
     * Método para buscar um autor especifico
     * @param id
     * @return Entidade do Autor encontrado
     */
    public Autor buscarAutorsId(Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }


}
