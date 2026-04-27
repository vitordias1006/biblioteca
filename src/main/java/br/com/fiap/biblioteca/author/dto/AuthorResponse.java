package br.com.fiap.biblioteca.author.dto;

import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.book.dto.BookSimpleResponse;
import br.com.fiap.biblioteca.book.model.Book;

import java.time.LocalDate;
import java.util.List;

public record AuthorResponse (
        Long id,
        String name,
        LocalDate birthDate,
        String nationality,
        Boolean active,
        List<BookSimpleResponse> books
){
    public static AuthorResponse fromEntity(Author author){
        return new AuthorResponse(
                author.getId(),
                author.getName(),
                author.getBirthDate(),
                author.getNationality(),
                author.getActive(),
                author.getBooks() == null ? List.of() :
                author.getBooks().stream()
                        .map(book -> new BookSimpleResponse(
                                book.getId(),
                                book.getTitle()))
                        .toList()
        );
    }
}
