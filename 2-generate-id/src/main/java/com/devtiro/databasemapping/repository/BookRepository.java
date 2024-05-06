package com.devtiro.databasemapping.repository;

import com.devtiro.databasemapping.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * A Spring Data JPA Repository for interacting with {@link Book}.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
