package br.com.fiap.biblioteca.book.dto;

import br.com.fiap.biblioteca.book.model.Book;

public record BookSimpleResponse(Long id, String title) {
    public static  BookSimpleResponse fromEntity(Book book) {
        return new BookSimpleResponse(
                book.getId(),
                book.getTitle()
        );
    }
}
