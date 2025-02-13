package net.weg.bibliotecaapi.Controller;

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
    public ResponseEntity<UsuarioResponse> postUsuario(@RequestBody @Validated UsuarioRequest usuarioRequest) {
        try {
            return new ResponseEntity<>(service.adicionarUsuario(usuarioRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> putUsuario(@RequestBody @Validated UsuarioRequest usuarioRequest, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarUsuario(usuarioRequest, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        try {
            service.deletarUsuario(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> getUsuarioByID(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarUsuarioResponseId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> getUsuario() {
        try {
            return new ResponseEntity<>(service.buscarUsuarios(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    
}
