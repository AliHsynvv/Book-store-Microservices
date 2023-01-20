package com.bookstore.bookservice.service;

import com.bookstore.bookservice.dto.BookRequest;
import com.bookstore.bookservice.dto.BookResponse;
import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository repository;

    public void createBook(BookRequest bookRequest) {
        Book book = Book.builder()
                .description(bookRequest.getDescription())
                .name(bookRequest.getName())
                .price(bookRequest.getPrice())
                .build();

        repository.save(book);
        log.info("Book {} is saved", book.getId());
    }

    public List<BookResponse> getAllBook() {
        List<Book> book = repository.findAll();
        return book.stream().map(this::mapToBookResponse).toList();
    }

    private BookResponse mapToBookResponse(Book book) {
        return BookResponse.builder()
                .id(book.getId())
                .description(book.getDescription())
                .name(book.getName())
                .price(book.getPrice())
                .build();
    }
}
