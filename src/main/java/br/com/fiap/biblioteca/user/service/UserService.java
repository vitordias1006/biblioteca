package br.com.fiap.biblioteca.user.service;

import br.com.fiap.biblioteca.author.model.Author;
import br.com.fiap.biblioteca.user.dto.UserRequest;
import br.com.fiap.biblioteca.user.dto.UserResponse;
import br.com.fiap.biblioteca.user.model.User;
import br.com.fiap.biblioteca.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

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

    public UserResponse update(UserRequest request){
        User user = request.toEntity();
        User response = repository.save(user);
        return UserResponse.fromEntity(response);
    }

    public void delete(Long id){
        User user = repository.findById(id)
                .orElseThrow(()-> new RuntimeException("Usuário não encontrado"));

        repository.delete(user);
    }

}
