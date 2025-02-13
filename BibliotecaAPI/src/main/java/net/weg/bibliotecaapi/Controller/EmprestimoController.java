package net.weg.bibliotecaapi.Controller;

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
    public ResponseEntity<EmprestimoResponse> postEmprestimo(@RequestBody @Validated EmprestimoRequest emprestimoRequest) {
        try {
            return new ResponseEntity<>(service.adicionarEmprestimo(emprestimoRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmprestimoResponse> putEmprestimo(@RequestBody @Validated EmprestimoRequest emprestimoRequest, @PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.atualizarEmprestimo(emprestimoRequest, id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmprestimo(@PathVariable Integer id) {
        try {
            service.deletarEmprestimo(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmprestimoResponse> getEmprestimoByID(@PathVariable Integer id) {
        try {
            return new ResponseEntity<>(service.buscarEmprestimoResponseId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping
    public ResponseEntity<List<EmprestimoResponse>> getEmprestimo() {
        try {
            return new ResponseEntity<>(service.buscarEmprestimos(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
    
}
