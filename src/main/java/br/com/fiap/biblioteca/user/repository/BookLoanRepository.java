package br.com.fiap.biblioteca.user.repository;

import br.com.fiap.biblioteca.user.model.BookLoan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {
}
