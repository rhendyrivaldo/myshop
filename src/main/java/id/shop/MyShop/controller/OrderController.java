package id.shop.MyShop.controller;

import id.shop.MyShop.dto.OrderDTO;
import id.shop.MyShop.model.Order;
import id.shop.MyShop.model.Product;
import id.shop.MyShop.service.OrderService;
import id.shop.MyShop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(
            OrderService orderService
    ) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDTO> getAllOrders() {
        return orderService.getOrders();
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Map<Long, Integer> productIdToQuantityMap) {
        Order savedOrder = orderService.createOrder(productIdToQuantityMap);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }
}
