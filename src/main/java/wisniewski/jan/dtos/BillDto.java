package wisniewski.jan.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BillDto {
    //data
    //lokal
    private BigDecimal totalPrice;
    private String paymentType;
    private Long orderId;

}

