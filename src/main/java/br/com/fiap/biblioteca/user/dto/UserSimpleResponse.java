package br.com.fiap.biblioteca.user.dto;

import br.com.fiap.biblioteca.user.model.User;

public record UserSimpleResponse(
        Long id,
        String name) {
    public static UserSimpleResponse fromEntity(User user) {
        return new UserSimpleResponse(user.getId(), user.getName());
    }
}
