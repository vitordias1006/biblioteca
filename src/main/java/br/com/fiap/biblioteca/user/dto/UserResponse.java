package br.com.fiap.biblioteca.user.dto;

import br.com.fiap.biblioteca.book.dto.BookSimpleResponse;
import br.com.fiap.biblioteca.user.model.User;

import java.time.LocalDate;
import java.util.List;

public record UserResponse(
        Long id,
        String name,
        String email,
        LocalDate birthDate,
        List<BookSimpleResponse> booksLoaned
) {
    public static UserResponse fromEntity(User user) {
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getBirthDate(),
                user.getMyBooks() == null ? List.of() :
                        user.getMyBooks().stream()
                                .map(book -> new BookSimpleResponse(
                                        book.getId(),
                                        book.getTitle()))
                                .toList()
        );
    }
}
