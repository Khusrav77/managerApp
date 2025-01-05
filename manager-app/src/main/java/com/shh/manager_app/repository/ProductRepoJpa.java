package com.shh.manager_app.repository;

import com.shh.manager_app.entity.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepoJpa {
    List<Product> findAll();

    Product save(Product product);

    Optional<Product> findById(Integer id);

    void deleteById(Integer id);
}
