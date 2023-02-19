package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    @Test
    public void testAdd() {
        Repository repository = new Repository();
        ProductManager productManager = new ProductManager(repository);

        Book book1 = new Book(1, "book1", 200, "autor1");
        Book book2 = new Book(2, "book2", 240, "autor2");
        Book book3 = new Book(3, "book3", 290, "autor3");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);

        Product[] expected = {book1, book2, book3};
        Product[] actual = repository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearch() {
        Repository repository = new Repository();
        ProductManager productManager = new ProductManager(repository);

        Book book1 = new Book(1, "book1", 200, "autor1");
        Book book2 = new Book(2, "book2", 240, "autor2");
        Book book3 = new Book(3, "book3", 290, "autor3");

        productManager.add(book1);
        productManager.add(book2);
        productManager.add(book3);

        Product[] expected = {book2};
        Product[] actual = productManager.searchBy("book2");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testAddProduct() {
        Repository repository = new Repository();
        ProductManager productManager = new ProductManager(repository);

        Product product = new Product(1234, "iPhone", 999);
        productManager.add(product);
        Product[] expected = {product};

        Product[] result = repository.findAll();
        assertEquals(1, result.length);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchByText() {
        Repository repository = new Repository();
        ProductManager productManager = new ProductManager(repository);

        Product product1 = new Product(1, "iPhone", 999);
        Product product2 = new Product(2, "iPad", 799);

        repository.add(product1);
        repository.add(product2);
        Product[] expected = {product1};

        Product[] result = productManager.searchBy("iPhone");
        assertEquals(1, result.length);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void testSearchByEmptyRepository() {
        Repository repository = new Repository();
        ProductManager productManager = new ProductManager(repository);

        Product[] result = productManager.searchBy("iPhone");
        assertEquals(0, result.length);

    }

    @Test
    public void testSearchsWithWrongTextQuery() {
        Repository repository = new Repository();
        ProductManager productManager = new ProductManager(repository);

        Product product1 = new Product(1234, "iPhone", 999);
        Product product2 = new Product(5678, "iPad", 799);

        repository.add(product1);
        repository.add(product2);

        Product[] result = productManager.searchBy("Samsung");
        assertEquals(0, result.length);

    }

    @Test
    public void testSearchBy() {
        Repository repository = new Repository();
        ProductManager manager = new ProductManager(repository);

        Product product1 = new Product(1, "Product 1", 10);
        Product product2 = new Product(2, "Product 2", 20);
        Product product3 = new Product(3, "Product 3", 30);
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);

        Product[] searchResult = manager.searchBy("duct");

        assertEquals(3, searchResult.length);
        assertTrue(Arrays.asList(searchResult).contains(product1));
        assertTrue(Arrays.asList(searchResult).contains(product2));
    }
}