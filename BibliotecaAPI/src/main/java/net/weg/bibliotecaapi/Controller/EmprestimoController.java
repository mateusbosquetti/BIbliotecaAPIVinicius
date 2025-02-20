package net.weg.bibliotecaapi.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.EmprestimoRequest;
import net.weg.bibliotecaapi.DTO.Request.EmprestimoRequest;
import net.weg.bibliotecaapi.DTO.Response.EmprestimoResponse;
import net.weg.bibliotecaapi.DTO.Response.EmprestimoResponse;
import net.weg.bibliotecaapi.Service.EmprestimoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emprestimo")
@AllArgsConstructor
public class EmprestimoController {

    private EmprestimoService service;
    
    @PostMapping
    @Tag(name = "Emprestimo", description = "Operações relacionadas ao Emprestimo")
    @Operation(summary = "Post Emprestimo", description = "Método para postar um Emprestimo, retorna o JSON do Emprestimo + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<EmprestimoResponse> postEmprestimo(@RequestBody @Validated EmprestimoRequest emprestimoRequest) {

            return new ResponseEntity<>(service.adicionarEmprestimo(emprestimoRequest), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    @Tag(name = "Emprestimo", description = "Operações relacionadas ao Emprestimo")
    @Operation(summary = "Put Emprestimo", description = "Método para atualizar um Emprestimo, retorna o JSON do Emprestimo + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<EmprestimoResponse> putEmprestimo(@RequestBody @Validated EmprestimoRequest emprestimoRequest, @PathVariable Integer id) {

            return new ResponseEntity<>(service.atualizarEmprestimo(emprestimoRequest, id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @Tag(name = "Emprestimo", description = "Operações relacionadas ao Emprestimo")
    @Operation(summary = "Delete Emprestimo", description = "Método para deletar um Emprestimo, retorna o JSON do Emprestimo + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<Void> deleteEmprestimo(@PathVariable Integer id) {

            service.deletarEmprestimo(id);
            return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    @Tag(name = "Emprestimo", description = "Operações relacionadas ao Emprestimo")
    @Operation(summary = "Get Emprestimo By ID", description = "Método para buscar um Emprestimo (Id), retorna o JSON do Emprestimo + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<EmprestimoResponse> getEmprestimoByID(@PathVariable Integer id) {

            return new ResponseEntity<>(service.buscarEmprestimoResponseId(id), HttpStatus.OK);

    }

    @GetMapping
    @Tag(name = "Emprestimo", description = "Operações relacionadas ao Emprestimo")
    @Operation(summary = "Get Emprestimo", description = "Método para listar todos os Emprestimo, retorna o JSON dos Emprestimo + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<List<EmprestimoResponse>> getEmprestimo() {

            return new ResponseEntity<>(service.buscarEmprestimos(), HttpStatus.OK);

    }
    
}
