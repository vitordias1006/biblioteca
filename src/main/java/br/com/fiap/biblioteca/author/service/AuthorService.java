package br.com.fiap.biblioteca.author.service;

import br.com.fiap.biblioteca.author.dto.AuthorRequest;
import br.com.fiap.biblioteca.author.dto.AuthorResponse;
import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.author.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

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
        Author author = repository.findByIdWithBooks(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return AuthorResponse.fromEntity(author);
    }

    public AuthorResponse update(Long id, AuthorRequest request){
        Author author = repository.findById(id).orElseThrow(
                () ->  new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        author.setName(request.name());
        author.setActive(request.active());
        author.setBirthDate(request.birthDate());
        author.setNationality(request.nationality());
        Author response = repository.save(author);

        return AuthorResponse.fromEntity(response);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }
}
