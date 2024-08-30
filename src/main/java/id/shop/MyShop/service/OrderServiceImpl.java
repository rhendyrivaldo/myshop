package id.shop.MyShop.service;

import id.shop.MyShop.dto.OrderDTO;
import id.shop.MyShop.dto.ProductDTO;
import id.shop.MyShop.model.Order;
import id.shop.MyShop.model.OrderProduct;
import id.shop.MyShop.model.Product;
import id.shop.MyShop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private ProductService productService;
    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(
            ProductService productService,
            OrderRepository orderRepository
    ) {
        this.productService = productService;
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderDTO> getOrders() {
        List<Order> orders = orderRepository.findAll();
        List<OrderDTO> result = new ArrayList<>();
        for (Order order : orders) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setCreatedAt(order.getCreatedAt());

            List<ProductDTO> productDTOS = new ArrayList<>();

            Set<OrderProduct> orderProducts = order.getOrderProducts();
            for (OrderProduct orderProduct : orderProducts) {
                ProductDTO productDTO = new ProductDTO();
                Product product = orderProduct.getProduct();
                productDTO.setName(product.getName());
                productDTO.setType(product.getType());
                productDTO.setPrice(product.getPrice());
                productDTO.setQuantity(orderProduct.getQuantity());
                productDTOS.add(productDTO);
            }
            orderDTO.setProducts(productDTOS);
            orderDTO.setId(order.getId());
            orderDTO.setTotalPrice(order.getTotalPrice());
            result.add(orderDTO);
        }
        return result;
    }

    @Override
    public Order createOrder(Map<Long, Integer> productIdToQuantityMap) {
        Order order = new Order();
        Set<OrderProduct> orderProducts = new HashSet<>();
        long totalPrice = 0;
        for (Map.Entry<Long, Integer> e : productIdToQuantityMap.entrySet()) {
            Long productId = e.getKey();

            Product product = productService.getProduct(productId);

            if (product != null) {
                OrderProduct orderProduct = new OrderProduct();
                orderProduct.setOrder(order);
                orderProduct.setProduct(product);
                orderProduct.setQuantity(e.getValue());
                orderProducts.add(orderProduct);
                totalPrice += product.getPrice() * e.getValue();
            }
        }
        order.setOrderProducts(orderProducts);
        order.setTotalPrice(totalPrice);
        return orderRepository.save(order);
    }
}
