package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void testAdd() {
        Repository repository = new Repository();
        Product product = new Product(1, "product", 10);
        repository.add(product);
        Product[] expected = {product};
        Product[] result = repository.findAll();
        assertEquals(1, result.length);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testDeleteById() {
        Repository repository = new Repository();
        Product product1 = new Product(1, "product1", 10);
        Product product2 = new Product(2, "product2", 20);
        repository.add(product1);
        repository.add(product2);
        Product[] expected = {product2};

        repository.deleteById(1);
        Product[] result = repository.findAll();
        assertEquals(1, result.length);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    void testFindAll1() {
        Repository repository = new Repository();
        Product product1 = new Product(1, "Product 1", 10);
        Product product2 = new Product(2, "Product 2", 20);
        repository.add(product1);
        repository.add(product2);
        Product[] expected = new Product[]{product1, product2};
        Assertions.assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void testAddFidAll() {
        Repository repository = new Repository();

        Product product1 = new Product(1, "iPhone", 900);
        Product product2 = new Product(2, "iPad", 700);

        repository.add(product1);
        repository.add(product2);

        Product[] result = repository.findAll();
        assertEquals(2, result.length);
        assertEquals(product1, result[0]);
        assertEquals(product2, result[1]);

    }

    @Test
    public void testDeleteByIdrtwq() {
        Repository repository = new Repository();

        Product product1 = new Product(1, "iPhone", 300);
        Product product2 = new Product(5, "iPad", 460);

        repository.add(product1);
        repository.add(product2);
        Product[] expected = {product2};

        repository.deleteById(1);

        Product[] result = repository.findAll();
        assertEquals(1, result.length);
        Assertions.assertArrayEquals(expected, result);

    }

    @Test
    public void testNotFoundException() {
        Repository repository = new Repository();
        Product product1 = new Product(1, "product1", 10);
        Product product2 = new Product(2, "product2", 20);
        repository.add(product1);
        repository.add(product2);

        Assertions.assertThrows(NotFoundException.class,
                () -> repository.deleteById(3));
    }

    @Test
    public void testNotFoundException_Type() {
        int id = 123;

        assertThrows(NotFoundException.class, () -> {
            throw new NotFoundException(id);
        });
    }

    @Test
    public void testNotFoundException_Message() {
        int id = 123;

        // Act
        NotFoundException exception = new NotFoundException(id);

        // Assert
        assertEquals("Товар id 123 не найден", exception.getMessage());
    }
}