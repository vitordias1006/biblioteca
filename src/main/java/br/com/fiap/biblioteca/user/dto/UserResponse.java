package br.com.fiap.biblioteca.user.dto;

import br.com.fiap.biblioteca.user.model.User;

import java.time.LocalDate;

public record UserResponse(
        Long id,
        String name,
        String email,
        LocalDate birthDate
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthDate()
        );
    }
}
