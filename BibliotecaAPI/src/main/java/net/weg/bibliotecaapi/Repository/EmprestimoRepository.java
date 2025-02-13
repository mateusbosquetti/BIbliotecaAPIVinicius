package net.weg.bibliotecaapi.Repository;

import net.weg.bibliotecaapi.Entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
}
