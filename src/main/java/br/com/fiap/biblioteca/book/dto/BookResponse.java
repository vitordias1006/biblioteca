package br.com.fiap.biblioteca.book.dto;

import br.com.fiap.biblioteca.book.model.Book;

import java.time.LocalDate;

public record BookResponse(
        Long id,
        String title,
        LocalDate releaseDate,
        String synopsis,
        String publisher,
        String author,
        String loanedTo
) {
    public static BookResponse fromEntity(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getReleaseDate(),
                book.getSynopsis(),
                book.getPublisher(),
                book.getAuthor().getName(),
                book.getUser() != null ? book.getUser().getName() : null
        );
    }
}
