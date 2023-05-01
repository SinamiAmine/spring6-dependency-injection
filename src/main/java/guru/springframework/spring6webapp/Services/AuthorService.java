package guru.springframework.spring6webapp.Services;

import guru.springframework.spring6webapp.domain.Author;

public interface AuthorService {

    public Iterable<Author> findAll();
}
