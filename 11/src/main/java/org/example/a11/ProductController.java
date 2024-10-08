package org.example.a11;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final List<Product> products = new ArrayList<>();
    public ProductController() {
        products.add(new Product(1, "Mask"));
        products.add(new Product(2, "Gloves"));
    }
    @GetMapping
    public List<Product> getProducts() {
        return products;
    }
    @GetMapping("/count") public int countProducts() {
        return products.size();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable("id") int id) {
        return products.stream()
                .filter(p -> p.getId() == id).findFirst().orElse(null);
    } }