package br.com.fiap.biblioteca.book.repository;

import br.com.fiap.biblioteca.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByTitle(String title);
}
