package net.weg.bibliotecaapi.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.LivroRequest;
import net.weg.bibliotecaapi.DTO.Request.LivroRequest;
import net.weg.bibliotecaapi.DTO.Response.LivroResponse;
import net.weg.bibliotecaapi.DTO.Response.LivroResponse;
import net.weg.bibliotecaapi.Service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
@AllArgsConstructor
public class LivroController {

    private LivroService service;

    @PostMapping
    @Tag(name = "Livro", description = "Operações relacionadas ao Livro")
    @Operation(summary = "Post Livro", description = "Método para postar um Livro, retorna o JSON do Livro + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<LivroResponse> postLivro(@RequestBody @Validated LivroRequest livroRequest) {

        return new ResponseEntity<>(service.adicionarLivro(livroRequest), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    @Tag(name = "Livro", description = "Operações relacionadas ao Livro")
    @Operation(summary = "Put Livro", description = "Método para atualizar um Livro, retorna o JSON do Livro + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<LivroResponse> putLivro(@RequestBody @Validated LivroRequest livroRequest, @PathVariable Integer id) {

        return new ResponseEntity<>(service.atualizarLivro(livroRequest, id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @Tag(name = "Livro", description = "Operações relacionadas ao Livro")
    @Operation(summary = "Delete Livro", description = "Método para deletar um Livro, retorna o JSON do Livro + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<Void> deleteLivro(@PathVariable Integer id) {

        service.deletarLivro(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    @Tag(name = "Livro", description = "Operações relacionadas ao Livro")
    @Operation(summary = "Get Livro By ID", description = "Método para buscar um Livro (Id), retorna o JSON do Livro + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<LivroResponse> getLivroByID(@PathVariable Integer id) {

        return new ResponseEntity<>(service.buscarLivroResponseId(id), HttpStatus.OK);

    }

    @GetMapping
    @Tag(name = "Livro", description = "Operações relacionadas ao Livro")
    @Operation(summary = "Get Livro", description = "Método para listar todos os Livro, retorna o JSON dos Livro + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<List<LivroResponse>> getLivro() {

        return new ResponseEntity<>(service.buscarLivros(), HttpStatus.OK);

    }

}
