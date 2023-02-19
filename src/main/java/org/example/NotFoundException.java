package org.example;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("Товар id " + id + " не найден");
    }
}
