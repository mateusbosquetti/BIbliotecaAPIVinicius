package net.weg.bibliotecaapi.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.weg.bibliotecaapi.DTO.Response.UsuarioResponse;

import java.util.List;

@Builder
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;

    @Column(nullable = false)
    public String cpf;
    @Column(nullable = false)
    public String senha;

    @OneToMany(mappedBy = "usuario")
    public List<Emprestimo> emprestimos;

    public UsuarioResponse toDTO() {
        return new UsuarioResponse(
                this.id,
                this.cpf,
                this.senha
        );
    }
}
