package br.com.fiap.biblioteca.user.service;

import br.com.fiap.biblioteca.book.model.Book;
import br.com.fiap.biblioteca.book.repository.BookRepository;
import br.com.fiap.biblioteca.user.dto.BookLoanResponse;
import br.com.fiap.biblioteca.user.dto.UserRequest;
import br.com.fiap.biblioteca.user.dto.UserResponse;
import br.com.fiap.biblioteca.user.model.BookLoan;
import br.com.fiap.biblioteca.user.model.User;
import br.com.fiap.biblioteca.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final BookRepository bookRepository;

    public UserResponse create(UserRequest request){
        User user = request.toEntity();
        User response = repository.save(user);
        return UserResponse.fromEntity(response);
    }

    public List<UserResponse> findAll(){
        List<User> users = repository.findAll();
        return users.stream()
                .map(UserResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public UserResponse findById(Long id){
        User user = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));
        return UserResponse.fromEntity(user);
    }

    public UserResponse update(Long id, UserRequest request){
        User user = repository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        user.setName(request.name());
        user.setEmail(request.email());
        user.setBirthDate(request.birthDate());

        User response = repository.save(user);
        return UserResponse.fromEntity(response);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public BookLoanResponse requestBookLoan(UserRequest request){
        User user = request.toEntity();
        Book book = bookRepository.findByTitle(request.bookTitle());
        BookLoan bookLoan = BookLoan.builder()
                .user(user)
                .book(book)
                .build();
        return BookLoanResponse.fromEntity(bookLoan);
    }

}
