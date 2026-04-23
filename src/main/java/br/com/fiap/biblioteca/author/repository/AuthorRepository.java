package br.com.fiap.biblioteca.author.repository;

import br.com.fiap.biblioteca.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
