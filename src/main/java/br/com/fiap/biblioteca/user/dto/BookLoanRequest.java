package br.com.fiap.biblioteca.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookLoanRequest (
        @NotNull Long userId,
        @NotBlank String bookTitle){
}
