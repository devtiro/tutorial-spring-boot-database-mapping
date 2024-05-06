package com.devtiro.databasemapping.domain;


import com.devtiro.databasemapping.DatabaseMappingApplication;
import com.devtiro.databasemapping.repository.AuthorRepository;
import com.devtiro.databasemapping.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class BookRepositoryTest {


    private final AuthorRepository authorRepository;

    private final BookRepository bookRepository;

    @Autowired
    public BookRepositoryTest(final AuthorRepository authorRepository, final BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Test
    public void testSaveBook() {
        // Given
        final Book book = new Book(
                "1234567890123",
                "Spring Boot in Action",
                "A comprehensive guide to Spring Boot",
                null
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
                "A comprehensive guide to Spring Boot",
                null
        );
        bookRepository.save(book);

        // When
        Optional<Book> optionalBook = bookRepository.findById("1234567890123");

        // Then
        assertThat(optionalBook).isPresent();
        assertThat(optionalBook).contains(book);
    }

    @Test
    public void testFindByAuthorId() {
        // Given
        final Author author = new Author(
                null,
                "John Doe",
                "A prolific author",
                null
        );
        final Author savedAuthor = authorRepository.save(author);

        final Book book = new Book(
                "1234567890123",
                "Spring Boot in Action",
                "A comprehensive guide to Spring Boot",
                savedAuthor
        );
        final Book savedBook = bookRepository.save(book);
        author.setBooks(List.of(savedBook));

        // When
        Optional<Book> result = bookRepository.findByAuthorId(author.getId());

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getAuthor()).isEqualTo(savedAuthor);
        assertThat(result).contains(savedBook);
    }

    @Test
    public void testDeleteBook() {
        // Given
        final Book book = new Book(
                "1234567890123",
                "Spring Boot in Action",
                "A comprehensive guide to Spring Boot",
                null
        );
        final Book savedBook = bookRepository.save(book);

        // When
        bookRepository.delete(savedBook);

        // Then
        Optional<Book> optionalBook = bookRepository.findById("1234567890123");
        assertThat(optionalBook).isNotPresent();
    }
}
