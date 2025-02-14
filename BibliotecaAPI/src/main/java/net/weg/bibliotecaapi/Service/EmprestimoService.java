package net.weg.bibliotecaapi.Service;

import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.EmprestimoRequest;
import net.weg.bibliotecaapi.DTO.Request.EmprestimoRequest;
import net.weg.bibliotecaapi.DTO.Response.EmprestimoResponse;
import net.weg.bibliotecaapi.DTO.Response.EmprestimoResponse;
import net.weg.bibliotecaapi.Entity.Emprestimo;
import net.weg.bibliotecaapi.Entity.Emprestimo;
import net.weg.bibliotecaapi.Repository.EmprestimoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmprestimoService {

    public EmprestimoRepository repository;
    public LivroService livroService;
    public UsuarioService usuarioService;

    /**
     * Método para adicionar um Emprestimo novo
     * @param emprestimoRequest
     * @return DTO de resposta do Emprestimo
     */
    public EmprestimoResponse adicionarEmprestimo (EmprestimoRequest emprestimoRequest) {
        Emprestimo emprestimo = repository.save(toEntity(emprestimoRequest));
        return emprestimo.toDTO();
    }

    /**
     * Método para converter DTO de requisição para Entidade
     *@param emprestimoRequest
     * @return Lista de DTO's de response do Emprestimo
     */
    private Emprestimo toEntity(EmprestimoRequest emprestimoRequest) {
        return Emprestimo.builder()
                .livro(livroService.buscarLivroID(emprestimoRequest.livro_id()))
                .usuario(usuarioService.buscarUsuarioID(emprestimoRequest.usuario_id()))
                .horarioFeito(LocalDate.now())
                .build();
    }

    /**
     * Método para listar todos os Emprestimos
     * @return Lista de DTO's de response do Emprestimo
     */
    public List<EmprestimoResponse> buscarEmprestimos () {
        return repository.findAll().stream().map(Emprestimo::toDTO).collect(Collectors.toList());
    }

    /**
     * Método para buscar um Emprestimo especifico
     * @param id
     * @return DTO de resposta do Emprestimo encontrado
     */
    public EmprestimoResponse buscarEmprestimoResponseId(Integer id) {
        Emprestimo emprestimo = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return emprestimo.toDTO();
    }

    /**
     * Método para deletar um Emprestimo especifico
     * @param id
     * @return void
     */
    public void deletarEmprestimo(Integer id) {
        buscarEmprestimoResponseId(id);
        repository.deleteById(id);
    }

    /**
     * Método para editar um Emprestimo especifico
     * @param emprestimoRequest
     * @param id
     * @return DTO de resposta do Emprestimo encontrado
     */
    public EmprestimoResponse atualizarEmprestimo(EmprestimoRequest emprestimoRequest, Integer id) {
        buscarEmprestimoResponseId(id);

        Emprestimo emprestimo = toEntity(emprestimoRequest);
        emprestimo.setId(id);
        repository.save(emprestimo);
        return emprestimo.toDTO();
    }
    
}
