package com.shh.manager_app.controllers;

import com.shh.manager_app.entity.Product;
import com.shh.manager_app.payload.NewProduct;
import com.shh.manager_app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("catalogue/products")
public class ProductsController {
    private final ProductService productService;

    @GetMapping(value = "list")
    public String getProductslist(Model model) {
        return "catalogue/products/list";
    }

    @GetMapping()
    public String getNewProductsPage() {
        return "catalogue/products/new_product";
    }

    @PostMapping("create")
    public String createProduct(NewProduct newProduct) {
        Product product = this.productService.createProduct(newProduct.title(), newProduct.detail());
        return "redirect:/catalogue/products/%d" .formatted(product.getId());
    }
}
