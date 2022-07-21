package ru.job4j.forum.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.forum.model.Authority;

import java.util.Optional;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Optional<Authority> findAuthorityByAuthority(String authority);
}