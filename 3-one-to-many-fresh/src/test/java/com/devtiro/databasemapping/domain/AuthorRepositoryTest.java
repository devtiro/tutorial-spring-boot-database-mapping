package com.devtiro.databasemapping.domain;

import com.devtiro.databasemapping.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AuthorRepositoryTest {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorRepositoryTest(final AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Test
    public void testSaveAuthor() {
        // Given
        final Author author = new Author(
                null,
                "John Doe",
                "A prolific author",
                null
        );

        // When
        Author savedAuthor = authorRepository.save(author);

        // Then
        assertThat(savedAuthor.getId()).isNotNull();
    }

    @Test
    public void testFindById() {
        // Given
        final Author author = new Author(
                null,
                "John Doe",
                "A prolific author",
                null
        );
        final Author savedAuthor = authorRepository.save(author);

        // When
        final Optional<Author> optionalAuthor = authorRepository.findById(author.getId());

        // Then
        assertThat(optionalAuthor).isPresent();
        assertThat(optionalAuthor).contains(savedAuthor);
    }

    @Test
    public void testFindByName() {
        // Given
        final Author author1 = new Author(
                null,
                "John Doe",
                "A prolific author",
                null

        );
        final Author author2 = new Author(
                null,
                "Jane Smith",
                "An accomplished writer",
                null
        );
        authorRepository.save(author1);
        final Author savedAuthor2 = authorRepository.save(author2);

        // When
        Optional<Author> result = authorRepository.findByName("Jane Smith");

        // Then
        assertThat(result).isPresent();
        assertThat(result).contains(savedAuthor2);
    }

    @Test
    @DirtiesContext
    public void testDeleteAuthor() {
        // Given
        final Author author = new Author(null, "John Doe", "A prolific author", null);
        final Author savedAuthor = authorRepository.save(author);

        // When
        authorRepository.delete(savedAuthor);

        // Then
        Optional<Author> result = authorRepository.findById(author.getId());
        assertThat(result).isNotPresent();
    }
}
