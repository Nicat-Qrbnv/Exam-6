package com.ltclab.exam6.service;

import com.ltclab.exam6.entity.UserOrder;
import com.ltclab.exam6.entity.Product;
import com.ltclab.exam6.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepo;
    private final ProductService productService;

    public UserOrder placeOrder(List<Long> productIds) {
        List<Product> products = productService.getAllProducts(productIds);
        UserOrder userOrder = new UserOrder();
        double totalPrice = 0.0;

        for (Product product : products) {
            if (product.getInStock()) {
                userOrder.getProducts().add(product);
                totalPrice += product.getPrice();
            }
        }

        userOrder.setTotalPrice(totalPrice);
        return orderRepo.save(userOrder);
    }
}