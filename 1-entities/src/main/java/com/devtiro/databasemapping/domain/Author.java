package com.devtiro.databasemapping.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

/**
 * A Plain Old Java Object to represent an Author of a {@link Book}.
 */
@Entity
@Table(name="authors")
public class Author {

    @Id
    private Long id;

    private String name;

    private String description;

    public Author() {
    }

    public Author(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Author author)) return false;
        return Objects.equals(id, author.id) && Objects.equals(name, author.name) && Objects.equals(description, author.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description);
    }
}
