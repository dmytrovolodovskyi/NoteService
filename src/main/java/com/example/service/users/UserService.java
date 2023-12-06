package com.example.service.users;

import com.example.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@SuppressWarnings("ALL")
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;

    public User findByUsername(String username) {
        Optional<User> user = repository.findById(username);

        return user.orElse(null);
    }

    public void saveUser(User user){
        repository.save(user);
    }

}