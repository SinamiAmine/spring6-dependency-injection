package guru.springframework.spring6webapp.Services.Impl;

import guru.springframework.spring6webapp.Repositories.AuthorRepository;
import guru.springframework.spring6webapp.Services.AuthorService;
import guru.springframework.spring6webapp.domain.Author;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
