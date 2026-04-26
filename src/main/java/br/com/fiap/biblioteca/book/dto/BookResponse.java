package br.com.fiap.biblioteca.book.dto;

import br.com.fiap.biblioteca.book.model.Book;

import java.time.LocalDate;

public record BookResponse(
        Long id,
        String title,
        LocalDate releaseDate,
        String synopsis,
        String publisher,
        Long authorId,
        Long userId
) {
    public static BookResponse fromEntity(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getReleaseDate(),
                book.getSynopsis(),
                book.getPublisher(),
                book.getAuthor() != null ? book.getAuthor().getId() : null,
                book.getUser() != null ? book.getUser().getId() : null
        );
    }
}
