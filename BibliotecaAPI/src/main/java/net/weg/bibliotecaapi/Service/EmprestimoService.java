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

    public EmprestimoResponse adicionarEmprestimo (EmprestimoRequest EmprestimoRequest) {
        Emprestimo emprestimo = repository.save(toEntity(EmprestimoRequest));
        return emprestimo.toDTO();
    }

    private Emprestimo toEntity(EmprestimoRequest emprestimoRequest) {
        return Emprestimo.builder()
                .livro(livroService.buscarLivroID(emprestimoRequest.livro_id()))
                .usuario(usuarioService.buscarUsuarioID(emprestimoRequest.usuario_id()))
                .horarioFeito(LocalDate.now())
                .build();
    }

    public List<EmprestimoResponse> buscarEmprestimos () {
        return repository.findAll().stream().map(Emprestimo::toDTO).collect(Collectors.toList());
    }

    public EmprestimoResponse buscarEmprestimoResponseId(Integer id) {
        Emprestimo emprestimo = repository.findById(id).orElseThrow(NoSuchElementException::new);
        return emprestimo.toDTO();
    }

    public void deletarEmprestimo(Integer id) {
        buscarEmprestimoResponseId(id);
        repository.deleteById(id);
    }

    public EmprestimoResponse atualizarEmprestimo(EmprestimoRequest emprestimoRequest, Integer id) {
        buscarEmprestimoResponseId(id);

        Emprestimo emprestimo = toEntity(emprestimoRequest);
        emprestimo.setId(id);
        repository.save(emprestimo);
        return emprestimo.toDTO();
    }
    
}
