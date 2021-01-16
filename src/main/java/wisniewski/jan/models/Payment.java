package wisniewski.jan.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import wisniewski.jan.enums.PaymentType;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payments")
@Data
public class Payment {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @OneToOne
    @JoinColumn(name = "bill_id", unique = true)
    private Bill bill;
}
