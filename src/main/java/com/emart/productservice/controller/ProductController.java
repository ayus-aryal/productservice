package com.emart.productservice.controller;


import com.emart.productservice.model.Product;
import com.emart.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping
    public Product create(@RequestBody Product p){
        return productService.createProduct(p);
    }

    // Get all products
    @GetMapping
    public List<Product> getAll(){
        return productService.getAllProducts();
    }

    // Get product by ID
    @GetMapping("/{id}")
    public Product getOne(@PathVariable Long id){
        return productService.getProductById(id);
    }

    // Update product
    @PutMapping("/{id}")
    public Product update(@PathVariable Long id, @RequestBody Product p){
        return productService.updateProduct(id, p);
    }

    // Delete product
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        productService.deleteProduct(id);
        return "DELETED";
    }

}
