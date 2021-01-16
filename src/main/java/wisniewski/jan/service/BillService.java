package wisniewski.jan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wisniewski.jan.dtos.BillDto;
import wisniewski.jan.enums.OrderStatus;
import wisniewski.jan.enums.PaymentType;
import wisniewski.jan.mapper.Mapper;
import wisniewski.jan.models.Bill;
import wisniewski.jan.models.Order;
import wisniewski.jan.models.Product;
import wisniewski.jan.repositories.BillRepository;
import wisniewski.jan.repositories.OrderRepository;
import wisniewski.jan.repositories.PaymentRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Slf4j
@RequiredArgsConstructor
@Service
public class BillService {

    private final OrderRepository orderRepository;
    private final BillRepository billRepository;


    public BillDto create(Long id) {
        log.info("Enter BillService -> calculate() with: " + id.toString());
        BigDecimal totalPrice = calculatePrice(id);
        Order order = orderRepository.findById(id).orElseThrow();
        Bill bill = Bill
                .builder()
                .totalPrice(totalPrice)
                .date(LocalDateTime.now())
                .order(order)
                .build();
        billRepository.save(bill);
        return Mapper.fromBillToBillDto(bill);

    }

    private BigDecimal calculatePrice(Long orderId) {
        return orderRepository
                .findById(orderId)
                .orElseThrow()
                .getProduct()
                .stream().map(Product::getPrice)
                .reduce(BigDecimal::add)
                .orElseThrow();
    }
}
