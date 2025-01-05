package com.shh.manager_app.service;

import com.shh.manager_app.entity.Product;
import com.shh.manager_app.repository.ProductRepoJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DefaultProductService implements ProductService {

    private ProductRepoJpa productRepoJpa;

    @Override
    public List<Product> getProducts() {
        return this.productRepoJpa.findAll();
    }

    @Override
    public Product createProduct(String title, String details) {
        return this.productRepoJpa.save(new Product(null, title, details));
    }

    @Override
    public Optional<Product> findProduct(Integer productId) {
        return this.productRepoJpa.findById(productId);
    }

    @Override
    public void updateProduct(Integer productId, String title, String details) {
        this.productRepoJpa.findById(productId).ifPresentOrElse(product -> {
            product.setName(title);
            product.setDetails(details);
        }, () -> {
            throw new NoSuchElementException();
        });
    }

    @Override
    public void deleteProduct(Integer productId) {
        this.productRepoJpa.deleteById(productId);
    }
}
