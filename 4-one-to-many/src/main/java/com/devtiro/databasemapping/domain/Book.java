package com.devtiro.databasemapping.domain;

import jakarta.persistence.*;

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
    @ManyToOne
    private Author author;

    public Book(){
    }

    public Book(final String isbn, final String title, final String description, final Author author) {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.author = author;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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
