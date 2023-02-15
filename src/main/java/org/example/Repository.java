package org.example;

public class Repository {
    private Product[] products = new Product[0];

    public void add(Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];

        }
        tmp[products.length] = product;
        products = tmp;

    }

    public Product[] findAll() {
        return products;
    }

    public void deleteById(int deleteId) {
        Product[] tmp = new Product[products.length - 1];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != deleteId) {
                tmp[index] = product;
                index++;
            }
        }
        products = tmp;
    }
}
