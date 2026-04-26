package br.com.fiap.biblioteca.book.model;

import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.user.model.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDate releaseDate;

    private String synopsis;

    private String publisher;

    @ManyToOne
    public Author author;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;
}
