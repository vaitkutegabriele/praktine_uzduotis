package com.example.praktineuzduotis.database;

import com.example.praktineuzduotis.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Database {

    public static List<Product> createProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Computer", "Apple", 2000, 10));
        products.add(new Product(2, "Phone", "Samsung", 346, 12));
        products.add(new Product(3, "Tablet", "Apple", 600, 5));
        products.add(new Product(4, "Computer", "Lenovo", 1200, 8));
        products.add(new Product(5, "Phone", "Apple", 760, 3));
        return products;
    }
}
