package com.devtiro.databasemapping.domain;


import com.devtiro.databasemapping.DatabaseMappingApplication;
import com.devtiro.databasemapping.repository.AuthorRepository;
import com.devtiro.databasemapping.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookRepositoryTest {

    private final BookRepository bookRepository;

    @Autowired
    public BookRepositoryTest(final BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Test
    public void testSaveBook() {
        // Given
        final Book book = new Book(
                "1234567890123",
                "Spring Boot in Action",
                "A comprehensive guide to Spring Boot"
        );

        // When
        final Book savedBook = bookRepository.save(book);

        // Then
        assertThat(savedBook.getIsbn()).isEqualTo(book.getIsbn());
    }

    @Test
    public void testFindById() {
        // Given
        final Book book = new Book(
                "1234567890123",
                "Spring Boot in Action",
                "A comprehensive guide to Spring Boot"
        );
        bookRepository.save(book);

        // When
        Optional<Book> optionalBook = bookRepository.findById("1234567890123");

        // Then
        assertThat(optionalBook).isPresent();
        assertThat(optionalBook).contains(book);
    }

    @Test
    public void testDeleteBook() {
        // Given
        final Book book = new Book(
                "1234567890123",
                "Spring Boot in Action",
                "A comprehensive guide to Spring Boot"
        );
        final Book savedBook = bookRepository.save(book);

        // When
        bookRepository.delete(savedBook);

        // Then
        Optional<Book> optionalBook = bookRepository.findById("1234567890123");
        assertThat(optionalBook).isNotPresent();
    }
}
