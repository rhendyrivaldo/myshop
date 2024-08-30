package id.shop.MyShop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductDTO {
    private String name;
    private String type;
    private long price;
    private int quantity;
}
