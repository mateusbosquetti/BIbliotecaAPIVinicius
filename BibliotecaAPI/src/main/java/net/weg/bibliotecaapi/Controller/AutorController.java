package net.weg.bibliotecaapi.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.AutorRequest;
import net.weg.bibliotecaapi.DTO.Response.AutorResponse;
import net.weg.bibliotecaapi.Service.AutorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autor")
@AllArgsConstructor
public class AutorController {

    private AutorService service;

    @PostMapping
    @Tag(name = "Autor", description = "Operações relacionadas ao Autor")
    @Operation(summary = "Post Autor", description = "Método para postar um Autor, retorna o JSON do Autor + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<AutorResponse> postAutor(@RequestBody @Validated AutorRequest autorRequest) {
        try {
            return new ResponseEntity<>(service.adicionarAutor(autorRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/{id}")
    @Tag(name = "Autor", description = "Operações relacionadas ao Autor")
    @Operation(summary = "Put Autor", description = "Método para atualizar um Autor, retorna o JSON do Autor + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<AutorResponse> putAutor(@RequestBody @Validated AutorRequest autorRequest, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarAutor(autorRequest, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/{id}")
    @Tag(name = "Autor", description = "Operações relacionadas ao Autor")
    @Operation(summary = "Delete Autor", description = "Método para deletar um Autor, retorna o JSON do Autor + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<Void> deleteAutor(@PathVariable Integer id) {
        try {
            service.deletarAutor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{id}")
    @Tag(name = "Autor", description = "Operações relacionadas ao Autor")
    @Operation(summary = "Get Autor By ID", description = "Método para buscar um Autor (Id), retorna o JSON do Autor + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<AutorResponse> getAutorByID(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarAutorResponseId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    @Tag(name = "Autor", description = "Operações relacionadas ao Autor")
    @Operation(summary = "Get Autor", description = "Método para listar todos os Autores, retorna o JSON dos Autores + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<List<AutorResponse>> getAutor() {
        try {
            return new ResponseEntity<>(service.buscarAutors(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
