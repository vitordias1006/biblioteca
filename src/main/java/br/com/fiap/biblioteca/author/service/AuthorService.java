package br.com.fiap.biblioteca.author.service;

import br.com.fiap.biblioteca.author.dto.AuthorRequest;
import br.com.fiap.biblioteca.author.dto.AuthorResponse;
import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.author.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository repository;

    public AuthorResponse create(AuthorRequest request){
        Author author = request.toEntity();
        Author response = repository.save(author);
        return AuthorResponse.fromEntity(response) ;
    }

    public List<AuthorResponse> getAll(){
        List<Author> authors = repository.findAll();
        return authors.stream()
                .map(AuthorResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public AuthorResponse getById(Long id){
        Author author = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Autor não encontrado"));

        return AuthorResponse.fromEntity(author);
    }

    public AuthorResponse update(AuthorRequest request){
        Author author = request.toEntity();
        Author response = repository.save(author);
        return AuthorResponse.fromEntity(response);
    }

    public void delete(Long id){
        Author author = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Autor não encontrado"));

        repository.delete(author);
    }
}
