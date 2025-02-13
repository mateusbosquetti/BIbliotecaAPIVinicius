package net.weg.bibliotecaapi.Controller;

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
    public ResponseEntity<LivroResponse> postLivro(@RequestBody @Validated LivroRequest livroRequest) {
        try {
            return new ResponseEntity<>(service.adicionarLivro(livroRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroResponse> putLivro(@RequestBody @Validated LivroRequest livroRequest, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarLivro(livroRequest, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLivro(@PathVariable Integer id) {
        try {
            service.deletarLivro(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<LivroResponse> getLivroByID(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarLivroResponseId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    public ResponseEntity<List<LivroResponse>> getLivro() {
        try {
            return new ResponseEntity<>(service.buscarLivros(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    
}
