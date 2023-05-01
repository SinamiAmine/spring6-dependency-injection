package guru.springframework.spring6webapp.Services.Impl;

import guru.springframework.spring6webapp.Repositories.BookRepository;
import guru.springframework.spring6webapp.Services.BookService;
import guru.springframework.spring6webapp.domain.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}
