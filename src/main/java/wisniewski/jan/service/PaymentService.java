package wisniewski.jan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wisniewski.jan.dtos.PaymentDto;
import wisniewski.jan.enums.OrderStatus;
import wisniewski.jan.exceptions.PaymentServiceException;
import wisniewski.jan.mapper.Mapper;
import wisniewski.jan.models.Bill;
import wisniewski.jan.models.Order;
import wisniewski.jan.models.Payment;
import wisniewski.jan.repositories.BillRepository;
import wisniewski.jan.repositories.OrderRepository;
import wisniewski.jan.repositories.PaymentRepository;
import wisniewski.jan.validator.PaymentDtoValidator;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final BillRepository billRepository;
    private final OrderRepository orderRepository;

    public PaymentDto create(Long id, PaymentDto paymentDto) {
        log.info("Enter paymentService -> create() with: " + paymentDto);
        Order order = orderRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Incorrect order id!"));
        PaymentDtoValidator validator = new PaymentDtoValidator();
        var errors = validator.validate(paymentDto);
        if (!errors.isEmpty()){
            throw new PaymentServiceException("Invalid payment!, errors: " + errors
                    .entrySet()
                    .stream()
                    .map(e -> e.getKey()+ " => "+e.getValue())
                    .collect(Collectors.joining(", ")));
        }
        if (order.getStatus().equals(OrderStatus.PAID)) {
            throw new IllegalStateException("This orders was paid");
        }
        Payment payment = Mapper.fromPaymentDtoToPayment(paymentDto);
        Bill bill = billRepository.findByOrderId(order.getId()).orElseThrow();
        payment.setBill(bill);
        payment.setDate(LocalDateTime.now());
        paymentRepository.save(payment);
        orderRepository.setNewStatus(id, OrderStatus.PAID);
        paymentDto.setId(payment.getId());
        return paymentDto;
    }
}
