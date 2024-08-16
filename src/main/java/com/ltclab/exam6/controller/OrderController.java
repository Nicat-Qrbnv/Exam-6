package com.ltclab.exam6.controller;

import com.ltclab.exam6.entity.UserOrder;
import com.ltclab.exam6.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping ("/make")
    public UserOrder create(@RequestBody List<Long> productIds) {
        return orderService.placeOrder(productIds);
    }
}