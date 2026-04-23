package br.com.fiap.biblioteca.author.service;

import br.com.fiap.biblioteca.author.dto.AuthorRequest;
import br.com.fiap.biblioteca.author.dto.AuthorResponse;
import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.author.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorResponse create(AuthorRequest request){
        Author author = request.toEntity();
        Author response = repository.save(author);
        return AuthorResponse.fromEntity(response) ;
    }
}
