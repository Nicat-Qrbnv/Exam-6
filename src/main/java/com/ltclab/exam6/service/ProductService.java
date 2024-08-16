package com.ltclab.exam6.service;

import com.ltclab.exam6.dto.ProductDto;
import com.ltclab.exam6.entity.Product;
import com.ltclab.exam6.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepo;
    private final ModelMapper mapper;

    public Product createProduct(ProductDto dto) {
        try {
            Product product = mapper.map(dto, Product.class);
            product.setInStock(true);
            return productRepo.save(product);
        } catch (DataIntegrityViolationException e){
            return null;
        }
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public List<Product> getAllProducts(List<Long> ids) {
        List<Product> products = new ArrayList<>();
        ids.forEach(id -> productRepo.findById(id).ifPresent(products::add));
        return products;
    }

}