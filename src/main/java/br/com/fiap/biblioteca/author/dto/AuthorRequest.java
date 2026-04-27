package br.com.fiap.biblioteca.author.dto;

import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.book.model.Book;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.List;

public record AuthorRequest(
        Long id,

        @NotBlank
        String name,

        @NotNull
        LocalDate birthDate,

        @NotBlank
        String nationality,

        @NotNull
        Boolean active){

    public Author toEntity(){
        return Author.builder()
                .name(name)
                .birthDate(birthDate)
                .nationality(nationality)
                .active(active)
                .build();
    }
}
