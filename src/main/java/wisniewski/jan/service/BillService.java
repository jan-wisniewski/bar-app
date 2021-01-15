package wisniewski.jan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import wisniewski.jan.dtos.BillDto;
import wisniewski.jan.enums.PaymentType;
import wisniewski.jan.models.Bill;
import wisniewski.jan.models.Product;
import wisniewski.jan.repositories.BillRepository;
import wisniewski.jan.repositories.OrderRepository;

import java.math.BigDecimal;

@Slf4j
@RequiredArgsConstructor
@Service
public class BillService {

    private final OrderRepository orderRepository;
    private final BillRepository billRepository;

    public BillDto create(@RequestParam Long id, @RequestBody BillDto billDto) {
        log.info("Enter BillService -> calculate() with: " + id.toString() + " and " + billDto);
        BigDecimal totalPrice = calculatePrice(id);
        Bill bill = Bill
                .builder()
                .totalPrice(totalPrice)
                .payment(PaymentType.valueOf(billDto.getPaymentType()))
                .build();
        billRepository.save(bill);
        billDto.setTotalPrice(totalPrice);
        return billDto;

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
