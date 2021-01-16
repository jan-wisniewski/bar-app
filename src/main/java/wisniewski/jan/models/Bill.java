package wisniewski.jan.models;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wisniewski.jan.enums.PaymentType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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

    private LocalDateTime date;

    @OneToOne
    @JoinColumn(name = "order_id", unique = true)
    private Order order;

    @OneToOne(mappedBy = "bill")
    private Payment payment;

}
