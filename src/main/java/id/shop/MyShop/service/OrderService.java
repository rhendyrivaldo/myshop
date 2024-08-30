package id.shop.MyShop.service;

import id.shop.MyShop.dto.OrderDTO;
import id.shop.MyShop.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {
    List<OrderDTO> getOrders();

    Order createOrder(Map<Long, Integer> productIdToQuantityMap);
}
