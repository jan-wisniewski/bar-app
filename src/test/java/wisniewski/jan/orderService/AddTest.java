package wisniewski.jan.orderService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import wisniewski.jan.dtos.OrderDto;
import wisniewski.jan.enums.PaymentType;
import wisniewski.jan.models.Bill;
import wisniewski.jan.models.Order;
import wisniewski.jan.models.Product;
import wisniewski.jan.repositories.OrderRepository;
import wisniewski.jan.repositories.ProductRepository;
import wisniewski.jan.service.OrderService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class AddTest {

    @InjectMocks
    private OrderService orderService;

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ProductRepository productRepository;

    @Test
    @DisplayName("when add order is successful, order dto is return")
    public void test1() {

        var orderDto = OrderDto
                .builder()
                .productIds(List.of(1L, 2L, 3L))
                .build();

        var product1 = Product
                .builder()
                .price(BigDecimal.valueOf(21))
                .name("Prod1")
                .build();

        var product2 = Product
                .builder()
                .price(BigDecimal.valueOf(33))
                .name("Prod2")
                .build();

        var product3 = Product
                .builder()
                .price(BigDecimal.valueOf(44))
                .name("Prod3")
                .build();

        var bill = Bill
                .builder()
                .totalPrice(BigDecimal.valueOf(1000))
                .build();

        var order = Order
                .builder()
                .product(List.of(product1, product2, product3))
                .bill(bill)
                .build();

        var orderWithId = Order
                .builder()
                .product(List.of(product1, product2, product3))
                .id(1L)
                .bill(bill)
                .build();

        bill.setOrder(order);

        Mockito
                .when(orderRepository.save(order))
                .thenReturn(orderWithId);

        Mockito
                .when(productRepository.findById(1L))
                .thenReturn(Optional.of(product1));

        Mockito
                .when(productRepository.findById(2L))
                .thenReturn(Optional.of(product2));

        Mockito
                .when(productRepository.findById(3L))
                .thenReturn(Optional.of(product3));

        Assertions.assertEquals(orderDto, orderService.add(orderDto));

    }
}
