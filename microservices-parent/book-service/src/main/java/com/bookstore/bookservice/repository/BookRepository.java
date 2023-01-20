package com.bookstore.bookservice.repository;

import com.bookstore.bookservice.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface BookRepository extends MongoRepository<Book,Long> {
}
