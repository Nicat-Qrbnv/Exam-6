package com.ltclab.exam6.controller;

import com.ltclab.exam6.dto.ProductDto;
import com.ltclab.exam6.entity.Product;
import com.ltclab.exam6.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/new")
    public Product create(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/all/filter")
    public List<Product> getAllProducts(@RequestParam(name = "ids") List<Long> productIds) {
        return productService.getAllProducts(productIds);
    }
}