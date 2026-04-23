package br.com.fiap.biblioteca.book.dto;

import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.book.model.Book;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

public record BookRequest(
        String title,
         LocalDate releaseDate,
         String synopsis,
         String publisher,
         Author author
) {
    public Book toEntity(){
        return Book.builder()
                .title(title)
                .releaseDate(releaseDate)
                .synopsis(synopsis)
                .publisher(publisher)
                .author(author)
                .build();
    }
}
