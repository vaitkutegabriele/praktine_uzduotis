package com.example.praktineuzduotis.controller;

import com.example.praktineuzduotis.database.Database;
import com.example.praktineuzduotis.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private static List<Product> products = Database.createProducts();

    @GetMapping("/products")

    public List<Product> getProducts() {
        return products;}

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        getProducts().add(product);
        return product;
    }

    @PutMapping("/products")
    public List<Product> updateProduct(@RequestBody Product productToUpdate) {
        Product existingProduct = getProducts().stream().filter(product -> productToUpdate.getId() == product.getId()).findAny().get();
        getProducts().remove(existingProduct);
        existingProduct.setId(productToUpdate.getId());
        existingProduct.setName(productToUpdate.getName());
        existingProduct.setBrand(productToUpdate.getBrand());
        existingProduct.setPrice(productToUpdate.getPrice());
        existingProduct.setQuantity(productToUpdate.getQuantity());
        getProducts().add(existingProduct);
        return products;

    }

    @DeleteMapping("/products")
    public List<Product> deleteProduct(@RequestBody Product product) {
        getProducts().remove(product);
        return products;
    }

}
