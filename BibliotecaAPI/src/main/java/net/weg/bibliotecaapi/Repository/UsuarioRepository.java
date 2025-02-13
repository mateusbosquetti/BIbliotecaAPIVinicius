package net.weg.bibliotecaapi.Repository;

import net.weg.bibliotecaapi.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
