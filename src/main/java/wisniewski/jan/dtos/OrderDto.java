package wisniewski.jan.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDto {
    private Long id;
    private String paymentType;
    private List<Long> productIds;
}
