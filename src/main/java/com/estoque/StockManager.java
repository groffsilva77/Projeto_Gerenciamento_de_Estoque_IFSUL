package com.estoque;

import java.util.ArrayList;
import java.util.List;

public class StockManager {
    private List<Product> products = new ArrayList<>();

    public boolean addProduct(Product product) {
        for (Product p : products) {
            if (p.getId().equals(product.getId()))
                return false;
        }
        return products.add(product);
    }

    public boolean deleteProduct(String id) {
        return products.removeIf(p -> p.getId().equals(id));
    }

    public Product findProduct(String id) {
        for (Product p : products) {
            if (p.getId().equals(id))
                return p;
        }
        return null;
    }

    public void printInventory() {
        System.out.printf("%-8s %-25s %-12s %-8s\n", "Code", "Product", "Quantity", "Price");
        for (Product p : products) {
            System.out.println(p);
        }
    }
}
