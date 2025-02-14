package net.weg.bibliotecaapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.bibliotecaapi.DTO.Response.EmprestimoResponse;

import java.time.LocalDate;

/**
 * @author Mateus Henrique Bosquetti
 * @version 1.0
 * @since 13/02/2025
 * Representa o Emprestimo no Sistema
 */
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

    /**
     * Converte uma entidade para um DTO de resposta
     * @return DTO de resposta da entidade Emprestimo
     */
    public EmprestimoResponse toDTO() {
        return new EmprestimoResponse(
                this.id,
                this.usuario.getId(),
                this.livro.getId(),
                this.horarioFeito
        );
    }
}