package com.devtiro.databasemapping.domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/**
 * A Plain Old Java Object to represent a Book, written by an {@link Author}.
 */
@Entity
@Table(name="books")
public class Book {

    @Id
    private String isbn;

    private String title;
    private String description;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authors_books",
            joinColumns = { @JoinColumn(name = "book_isbn") },
            inverseJoinColumns = { @JoinColumn(name = "author_id") }
    )
    private List<Author> authors;

    public Book(){
    }

    public Book(final String isbn, final String title, final String description, final List<Author> authors) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.authors = authors;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(isbn, book.isbn) && Objects.equals(title, book.title) && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, description);
    }
}
