package net.weg.bibliotecaapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.bibliotecaapi.DTO.Response.EmprestimoResponse;

import java.time.LocalDate;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    public Usuario usuario;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    public Livro livro;

    @Column(nullable = false)
    public LocalDate horarioFeito;

    public EmprestimoResponse toDTO() {
        return new EmprestimoResponse(
                this.id,
                this.usuario.getId(),
                this.livro.getId(),
                this.horarioFeito
        );
    }
}