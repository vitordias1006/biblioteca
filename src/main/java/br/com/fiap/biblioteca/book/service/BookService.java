package br.com.fiap.biblioteca.book.service;

import br.com.fiap.biblioteca.book.dto.BookRequest;
import br.com.fiap.biblioteca.book.dto.BookResponse;
import br.com.fiap.biblioteca.book.model.Book;
import br.com.fiap.biblioteca.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public BookResponse create (BookRequest  request) {
        Book book = request.toEntity();
        Book resonse = repository.save(book);
        return BookResponse.fromEntity(resonse);
    }

    public List<BookResponse> findAll() {
        List<Book> books = repository.findAll();
        return books.stream().
                map(BookResponse::fromEntity)
                .collect(Collectors.toList());
    }

    public BookResponse findById(Long id) {
        Book book = repository.findById(id).orElseThrow(()-> new RuntimeException("Livro não encontrado"));
        return BookResponse.fromEntity(book);
    }

    public BookResponse findByTitle(String title) {
        Book book = repository.findByTitle(title);
        return BookResponse.fromEntity(book);
    }

    public BookResponse update(Long id, BookRequest  request) {
        Book book = request.toEntity();
        Book response = repository.save(book);
        return BookResponse.fromEntity(response);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
