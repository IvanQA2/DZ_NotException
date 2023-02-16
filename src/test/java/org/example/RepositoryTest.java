package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryTest {
    @Test
    public void testAdd() {
        Repository repository = new Repository();
        Product product = new Product(1, "product", 10);
        repository.add(product);
        Product[] result = repository.findAll();
        assertEquals(1, result.length);
        assertEquals(product, result[0]);
    }

    @Test
    public void testDeleteById() {
        Repository repository = new Repository();
        Product product1 = new Product(1, "product1", 10);
        Product product2 = new Product(2, "product2", 20);
        repository.add(product1);
        repository.add(product2);
        repository.deleteById(1);
        Product[] result = repository.findAll();
        assertEquals(1, result.length);
        assertEquals(product2, result[0]);
    }

    @Test
    void testFindAll1() {
        Repository repository = new Repository();
        Product product1 = new Product(1, "Product 1", 10);
        Product product2 = new Product(2, "Product 2", 20);
        repository.add(product1);
        repository.add(product2);
        Product[] expected = new Product[]{product1, product2};
        assertArrayEquals(expected, repository.findAll());
    }

    @Test
    public void testDeleteByIdrtw() {
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

        repository.deleteById(1);

        Product[] result = repository.findAll();
        assertEquals(1, result.length);
        assertEquals(product2, result[0]);

    }
}