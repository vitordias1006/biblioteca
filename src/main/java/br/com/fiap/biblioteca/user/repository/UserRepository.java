package br.com.fiap.biblioteca.user.repository;

import br.com.fiap.biblioteca.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
