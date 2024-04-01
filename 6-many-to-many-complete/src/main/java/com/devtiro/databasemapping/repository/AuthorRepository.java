package com.devtiro.databasemapping.repository;

import com.devtiro.databasemapping.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A Spring Data JPA Repository for interacting with {@link Author}.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Optional<Author> findByName(String name);
}
