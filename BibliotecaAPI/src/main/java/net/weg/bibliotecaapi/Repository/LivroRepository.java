package net.weg.bibliotecaapi.Repository;

import net.weg.bibliotecaapi.Entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
}
