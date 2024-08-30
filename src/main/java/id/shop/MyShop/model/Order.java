package id.shop.MyShop.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter @Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime createdAt;

    private long totalPrice;

    @OneToMany(mappedBy = "order", cascade = CascadeType.PERSIST)
    private Set<OrderProduct> orderProducts;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }
}
