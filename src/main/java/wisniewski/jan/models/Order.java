package wisniewski.jan.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.transaction.annotation.Transactional;
import wisniewski.jan.enums.OrderStatus;
import wisniewski.jan.enums.PaymentType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Data
@Transactional
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime date;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> product;

    @OneToOne(mappedBy = "order")
    private Bill bill;

    @Enumerated(EnumType.STRING)
    private OrderStatus status = OrderStatus.UNPAID;

}
