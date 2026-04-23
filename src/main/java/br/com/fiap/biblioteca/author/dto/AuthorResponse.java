package br.com.fiap.biblioteca.author.dto;

import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.book.model.Book;

import java.time.LocalDate;
import java.util.List;

public record AuthorResponse (
        Long id,
        String name,
        LocalDate birthDate,
        String nationality,
        Boolean active,
        List<Book> books
){
    public static AuthorResponse fromEntity(Author author){
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBirthDate(),
                author.getNationality(),
                author.getActive(),
                author.getBooks()
        );
    }
}
