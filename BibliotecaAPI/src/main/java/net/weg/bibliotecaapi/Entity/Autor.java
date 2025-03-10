package net.weg.bibliotecaapi.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.bibliotecaapi.DTO.Response.AutorResponse;

import java.util.List;

/**
 * @author Mateus Henrique Bosquetti
 * @version 1.0
 * @since 13/02/2025
 * Representa o Autor no Sistema
 */
@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String nome;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    /**
     * Converte uma entidade para um DTO de resposta
     * @return DTO de resposta da entidade Autor
     */
    public AutorResponse toDTO() {
        return new AutorResponse(
                this.id,
                this.nome
        );
    }
}
