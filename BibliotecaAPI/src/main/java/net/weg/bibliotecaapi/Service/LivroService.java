package net.weg.bibliotecaapi.Service;

import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.LivroRequest;
import net.weg.bibliotecaapi.DTO.Request.LivroRequest;
import net.weg.bibliotecaapi.DTO.Response.LivroResponse;
import net.weg.bibliotecaapi.DTO.Response.LivroResponse;
import net.weg.bibliotecaapi.Entity.Autor;
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

    /**
     * Método para adicionar um Livro novo
     * @param LivroRequest
     * @return DTO de resposta do Livro
     */
    public LivroResponse adicionarLivro (LivroRequest LivroRequest) {
        Livro livro = repository.save(toEntity(LivroRequest));
        return livro.toDTO();
    }

    /**
     * Método para converter DTO de requisição para Entidade
     *@param livroRequest
     * @return Lista de DTO's de response do Livro
     */
    private Livro toEntity(LivroRequest livroRequest) {
        return Livro.builder()
                .nome(livroRequest.nome())
                .quantidade(livroRequest.quantidade())
                .autor(autorService.buscarAutorsId(livroRequest.autor_id()))
                .build();
    }

    /**
     * Método para listar todos os Livros
     * @return Lista de DTO's de response do Livro
     */
    public List<LivroResponse> buscarLivros () {
        return repository.findAll().stream().map(Livro::toDTO).collect(Collectors.toList());
    }

    /**
     * Método para buscar um Livro especifico
     * @param id
     * @return DTO de resposta do Livro encontrado
     */
    public LivroResponse buscarLivroResponseId(Integer id) {
        Livro livro = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return livro.toDTO();
    }

    /**
     * Método para deletar um Livro especifico
     * @param id
     * @return void
     */
    public void deletarLivro(Integer id) {
        buscarLivroResponseId(id);
        repository.deleteById(id);
    }

    /**
     * Método para editar um Livro especifico
     * @param livroRequest
     * @param id
     * @return DTO de resposta do Livro encontrado
     */
    public LivroResponse atualizarLivro(LivroRequest livroRequest, Integer id) {
        buscarLivroResponseId(id);

        Livro livro = toEntity(livroRequest);
        livro.setId(id);
        repository.save(livro);
        return livro.toDTO();
    }

    /**
     * Método para buscar um Livro especifico
     * @param id
     * @return Entidade do Livro encontrado
     */
    public Livro buscarLivroID (Integer id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

}
