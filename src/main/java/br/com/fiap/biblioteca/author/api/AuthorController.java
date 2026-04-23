package br.com.fiap.biblioteca.author.api;

import br.com.fiap.biblioteca.author.dto.AuthorRequest;
import br.com.fiap.biblioteca.author.dto.AuthorResponse;
import br.com.fiap.biblioteca.author.service.AuthorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/biblioteca")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @PostMapping
    public ResponseEntity<AuthorResponse> save(@Valid @RequestBody AuthorRequest request){
        return new ResponseEntity<>(this.service.create(request)  ,HttpStatus.CREATED);
    }
}
