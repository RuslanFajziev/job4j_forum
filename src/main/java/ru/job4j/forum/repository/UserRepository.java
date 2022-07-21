package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.User;

import java.util.Optional;
public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User> findUserByUsername(String username);
}