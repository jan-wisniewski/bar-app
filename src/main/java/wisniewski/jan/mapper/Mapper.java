package wisniewski.jan.mapper;

import wisniewski.jan.dtos.OrderDto;
import wisniewski.jan.dtos.ProductDto;
import wisniewski.jan.models.Order;
import wisniewski.jan.models.Product;

import java.util.stream.Collectors;

public interface Mapper {

    static Product fromProductDtoToProduct(ProductDto productDto) {
        return Product
                .builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .build();
    }

    static ProductDto fromProductToProductDto(Product product) {
        return ProductDto
                .builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    static OrderDto fromOrderToOrderDto(Order order) {
        return OrderDto
                .builder()
                .id(order.getId())
                .productIds(order.getProduct().stream().map(Product::getId).collect(Collectors.toList()))
                .build();
    }

    static Order fromOrderDtoToOrder(OrderDto orderDto) {
        return Order
                .builder()
                .build();
    }

}
