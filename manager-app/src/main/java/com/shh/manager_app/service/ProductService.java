package com.shh.manager_app.service;

import com.shh.manager_app.entity.Product;


import java.util.List;

import java.util.Optional;

public interface ProductService {

    List<Product> getProducts();

    Product createProduct(String title, String details);

    Optional<Product> findProduct(Integer productId);

    void updateProduct(Integer productId, String title, String details);

    void deleteProduct(Integer productId);
}
