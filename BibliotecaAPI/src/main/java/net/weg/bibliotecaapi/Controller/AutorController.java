package net.weg.bibliotecaapi.Controller;

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
    public ResponseEntity<AutorResponse> postAutor(@RequestBody @Validated AutorRequest autorRequest) {
        try {
            return new ResponseEntity<>(service.adicionarAutor(autorRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorResponse> putAutor(@RequestBody @Validated AutorRequest autorRequest, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarAutor(autorRequest, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAutor(@PathVariable Integer id) {
        try {
            service.deletarAutor(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorResponse> getAutorByID(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarAutorResponseId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    public ResponseEntity<List<AutorResponse>> getAutor() {
        try {
            return new ResponseEntity<>(service.buscarAutors(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }


}
