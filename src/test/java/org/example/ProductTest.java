package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ProductTest {

    @Test
    public void testProduct() {
        Product p = new Product(1, "Product", 100);
        assertEquals(1, p.getId());
        assertEquals("Product", p.getName());
        assertEquals(100, p.getCost());
    }

    @Test
    public void testBook() {
        Book b = new Book(2, "Book", 200, "Author");
        assertEquals(2, b.getId());
        assertEquals("Book", b.getName());
        assertEquals(200, b.getCost());
        assertEquals("Author", b.getAuthor());
    }
    @Test
    public void testSmartphone() {
        Smartphone s = new Smartphone(3, "Smartphone", 300, "Manufacturer");
        assertEquals(3, s.getId());
        assertEquals("Smartphone", s.getName());
        assertEquals(300, s.getCost());
        assertEquals("Manufacturer", s.getManufacturer());
    }



}
