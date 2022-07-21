package ru.job4j.forum.service;

import org.springframework.stereotype.Service;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.repository.AuthorityRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorityService {
    private AuthorityRepository authorityRepository;

    public AuthorityService(AuthorityRepository authorityRepository) {
        this.authorityRepository = authorityRepository;
    }

    public Authority findByAuthority(String authority) {
        Optional<Authority> optionalAuthority = authorityRepository.findAuthorityByAuthority(authority);
        if (optionalAuthority.isPresent()) {
            return optionalAuthority.get();
        }
        return new Authority();
    }

    public Authority findById(int id) {
        Authority rsl = new Authority();
        var findAuthority = authorityRepository.findById(id);
        if (findAuthority.isPresent()) {
            rsl = findAuthority.get();
        }
        return rsl;
    }

    public List<Authority> getAllAuthority() {
        List<Authority> lstAuthority = new ArrayList<Authority>();
        authorityRepository.findAll().forEach(lstAuthority::add);
        return lstAuthority;
    }
}