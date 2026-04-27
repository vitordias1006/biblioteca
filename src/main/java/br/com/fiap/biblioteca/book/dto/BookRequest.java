package br.com.fiap.biblioteca.book.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record BookRequest(
        @NotBlank
        String title,
        @NotNull
        LocalDate releaseDate,
        @NotBlank
        String synopsis,
        @NotBlank
        String publisher,
        @NotNull
        Long authorId
) {}
