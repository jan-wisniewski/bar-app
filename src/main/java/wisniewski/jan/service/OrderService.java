package wisniewski.jan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import wisniewski.jan.exceptions.OrderServiceException;
import wisniewski.jan.models.Order;
import wisniewski.jan.dtos.OrderDto;
import wisniewski.jan.repositories.OrderRepository;
import wisniewski.jan.repositories.ProductRepository;
import wisniewski.jan.validator.OrderDtoValidator;

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
        OrderDtoValidator validator = new OrderDtoValidator();
        var errors = validator.validate(orderDto);
        if (!errors.isEmpty()) {
            throw new OrderServiceException("Invalid order!, errors: " + errors
                    .entrySet()
                    .stream()
                    .map(e -> e.getKey()+ " => "+e.getValue())
                    .collect(Collectors.joining(", ")));
        }
        Order order = new Order();
        order.setDate(LocalDateTime.now());
        order.setProduct(orderDto.getProductIds()
                .stream()
                .map(e -> productRepository.findById(e).orElseThrow())
                .collect(Collectors.toList()));
        log.info("Order: " + order);
        orderRepository.save(order);
        orderDto.setId(order.getId());
        return orderDto;
    }
}
