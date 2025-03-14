package net.weg.bibliotecaapi.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import net.weg.bibliotecaapi.DTO.Request.UsuarioRequest;
import net.weg.bibliotecaapi.DTO.Request.UsuarioRequest;
import net.weg.bibliotecaapi.DTO.Response.UsuarioResponse;
import net.weg.bibliotecaapi.DTO.Response.UsuarioResponse;
import net.weg.bibliotecaapi.Service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
@AllArgsConstructor
public class UsuarioController {

    private UsuarioService service;

    @PostMapping
    @Tag(name = "Usuario", description = "Operações relacionadas ao Usuario")
    @Operation(summary = "Post Usuario", description = "Método para postar um Usuario, retorna o JSON do Usuario + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<UsuarioResponse> postUsuario(@RequestBody @Validated UsuarioRequest usuarioRequest) {

        return new ResponseEntity<>(service.adicionarUsuario(usuarioRequest), HttpStatus.OK);

    }

    @PutMapping("/{id}")
    @Tag(name = "Usuario", description = "Operações relacionadas ao Usuario")
    @Operation(summary = "Post Usuario", description = "Método para postar um Usuario, retorna o JSON do Usuario + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<UsuarioResponse> putUsuario(@RequestBody @Validated UsuarioRequest usuarioRequest, @PathVariable Integer id) {

        return new ResponseEntity<>(service.atualizarUsuario(usuarioRequest, id), HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    @Tag(name = "Usuario", description = "Operações relacionadas ao Usuario")
    @Operation(summary = "Post Usuario", description = "Método para postar um Usuario, retorna o JSON do Usuario + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {

        service.deletarUsuario(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    @GetMapping("/{id}")
    @Tag(name = "Usuario", description = "Operações relacionadas ao Usuario")
    @Operation(summary = "Post Usuario", description = "Método para postar um Usuario, retorna o JSON do Usuario + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<UsuarioResponse> getUsuarioByID(@PathVariable Integer id) {

        return new ResponseEntity<>(service.buscarUsuarioResponseId(id), HttpStatus.OK);

    }

    @GetMapping
    @Tag(name = "Usuario", description = "Operações relacionadas ao Usuario")
    @Operation(summary = "Post Usuario", description = "Método para postar um Usuario, retorna o JSON do Usuario + Status da requisição")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "422", description = "Falha do Cliente"),
            @ApiResponse(responseCode = "500", description = "Falha do Server")
    })
    public ResponseEntity<List<UsuarioResponse>> getUsuario() {

        return new ResponseEntity<>(service.buscarUsuarios(), HttpStatus.OK);
        
    }

}
