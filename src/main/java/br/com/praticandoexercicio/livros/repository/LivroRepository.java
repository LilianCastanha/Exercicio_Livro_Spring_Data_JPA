package br.com.praticandoexercicio.livros.repository;

import br.com.praticandoexercicio.livros.entities.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
