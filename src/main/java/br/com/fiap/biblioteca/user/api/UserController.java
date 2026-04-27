package br.com.fiap.biblioteca.user.api;

import br.com.fiap.biblioteca.user.dto.BookLoanRequest;
import br.com.fiap.biblioteca.user.dto.BookLoanResponse;
import br.com.fiap.biblioteca.user.dto.UserRequest;
import br.com.fiap.biblioteca.user.dto.UserResponse;
import br.com.fiap.biblioteca.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/biblioteca/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request) {
        UserResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody UserRequest request) {
        return ResponseEntity.ok(service.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/alugar-livros")
    public ResponseEntity<BookLoanResponse> loanBook(@Valid @RequestBody BookLoanRequest request) {
        return ResponseEntity.ok(service.requestBookLoan(request));
    }

}
