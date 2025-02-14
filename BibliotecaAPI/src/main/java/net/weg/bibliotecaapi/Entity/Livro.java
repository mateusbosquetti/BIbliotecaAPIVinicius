package net.weg.bibliotecaapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.bibliotecaapi.DTO.Response.LivroResponse;

import java.util.List;

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
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String nome;

    @Column(nullable = false)
    public Integer quantidade;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(nullable = false)
    public Autor autor;

    @OneToMany(mappedBy = "livro")
    public List<Emprestimo> emprestimos;

    /**
     * Converte uma entidade para um DTO de resposta
     * @return DTO de resposta da entidade Livro
     */
    public LivroResponse toDTO() {
        return new LivroResponse(
                this.id,
                this.nome,
                this.quantidade,
                this.autor.getId()
        );
    }
}
