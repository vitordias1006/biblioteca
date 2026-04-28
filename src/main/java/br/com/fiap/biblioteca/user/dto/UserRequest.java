package br.com.fiap.biblioteca.user.dto;

import br.com.fiap.biblioteca.user.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record UserRequest(
        Long id,
        @NotBlank
        String name,
        @NotBlank
        String email,
        @NotNull
        LocalDate birthDate
) {
    public User toEntity() {
        return User.builder()
                .name(name)
                .email(email)
                .birthDate(birthDate)
                .build();
    }
}
