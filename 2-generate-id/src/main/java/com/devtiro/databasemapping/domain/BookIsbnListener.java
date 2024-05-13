package com.devtiro.databasemapping.domain;

import jakarta.persistence.PrePersist;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class BookIsbnListener {

    @PrePersist
    public void prePersist(Book book) {
        if (null == book.getIsbn()) {
            book.setIsbn(generateISBN());
        }
    }

    private String generateISBN() {
        StringBuilder isbn = new StringBuilder("978");
        Random random = new Random();

        for (int i = 0; i < 9; i++) {
            isbn.append(random.nextInt(10));
        }

        int checksum = calculateChecksum(isbn.toString());
        isbn.append(checksum);

        return isbn.toString();
    }

    private int calculateChecksum(String isbn) {
        int sum = 0;
        for (int i = 0; i < isbn.length(); i++) {
            int digit = Character.getNumericValue(isbn.charAt(i));
            if (i % 2 == 0) {
                sum += digit;
            } else {
                sum += digit * 3;
            }
        }
        int remainder = sum % 10;
        return (10 - remainder) % 10;
    }
}
