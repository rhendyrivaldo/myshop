package id.shop.MyShop.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
public class OrderDTO {
    private long id;
    private LocalDateTime createdAt;
    private List<ProductDTO> products;
    private long totalPrice;
}
