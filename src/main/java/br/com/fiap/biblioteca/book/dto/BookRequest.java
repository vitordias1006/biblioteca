package br.com.fiap.biblioteca.book.dto;

import java.time.LocalDate;

public record BookRequest(
        String title,
         LocalDate releaseDate,
         String synopsis,
         String publisher,
         Long authorId
) {}
