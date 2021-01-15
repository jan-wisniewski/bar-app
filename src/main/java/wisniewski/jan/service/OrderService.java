package wisniewski.jan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import wisniewski.jan.mapper.Mapper;
import wisniewski.jan.models.Order;
import wisniewski.jan.enums.PaymentType;
import wisniewski.jan.dtos.OrderDto;
import wisniewski.jan.repositories.OrderRepository;
import wisniewski.jan.repositories.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    private final ProductRepository productRepository;

    public OrderDto add(OrderDto orderDto) {
        log.info("Enter orderService -> add() with: " + orderDto);
        Order order = Mapper.fromOrderDtoToOrder(orderDto);
        log.info("Order: " + order);
        order.setDate(LocalDateTime.now());
        order.setProduct(orderDto.getProductIds()
                .stream()
                .map(e -> productRepository.findById(e).orElseThrow())
                .collect(Collectors.toList()));
        orderRepository.save(order);
        return orderDto;
    }

}
