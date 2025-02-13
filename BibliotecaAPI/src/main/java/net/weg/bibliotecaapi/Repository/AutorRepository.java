package net.weg.bibliotecaapi.Repository;

import net.weg.bibliotecaapi.Entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
}
