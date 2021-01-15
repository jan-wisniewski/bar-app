package wisniewski.jan.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wisniewski.jan.enums.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bills")
@Data
public class Bill {
    @Id
    @GeneratedValue
    private Long id;

    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private PaymentType payment;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;

}
