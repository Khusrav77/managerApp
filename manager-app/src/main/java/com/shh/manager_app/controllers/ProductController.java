package com.shh.manager_app.controllers;

import com.shh.manager_app.entity.Product;
import com.shh.manager_app.payload.NewProduct;
import com.shh.manager_app.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(("catalogue/products/{productId:\\d+"))
public class ProductController {

    private final ProductService productService;


    @ModelAttribute("product")
    public Product product(@PathVariable("productId") int productId){
        return this.productService.findProduct(productId).orElseThrow();
    }

    @GetMapping()
    public String getProduct() {
        return "catalogue/products/product";
    }

    @GetMapping("edit")
    public String getEditProductPage() {
        return "catalogue/products/edit";
    }

    @PostMapping("edit")
    public String updateProduct(@ModelAttribute("product") Product product, NewProduct newProduct) {
        this.productService.updateProduct(product.getId(), newProduct.title(), newProduct.detail());
        return "redirect:/catalogue/products/%d".formatted(product.getId());
    }

    @PostMapping("delete")
    public String deleteProduct(@ModelAttribute("product") Product product) {
        this.productService.deleteProduct(product.getId());
        return "redirect:/catalogue/products/list";
    }
}
