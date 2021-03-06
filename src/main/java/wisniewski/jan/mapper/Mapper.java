package wisniewski.jan.mapper;

import wisniewski.jan.dtos.BillDto;
import wisniewski.jan.dtos.OrderDto;
import wisniewski.jan.dtos.PaymentDto;
import wisniewski.jan.dtos.ProductDto;
import wisniewski.jan.enums.PaymentType;
import wisniewski.jan.models.Bill;
import wisniewski.jan.models.Order;
import wisniewski.jan.models.Payment;
import wisniewski.jan.models.Product;

import java.util.List;
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
                .id(product.getId())
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

    static Payment fromPaymentDtoToPayment(PaymentDto paymentDto){
        return Payment
                .builder()
                .paymentType(PaymentType.valueOf(paymentDto.getPaymentType()))
                .build();
    }

    static Bill fromBillDtoToBill(BillDto billDto){
        return Bill
                .builder()
                .totalPrice(billDto.getTotalPrice())
                .build();
    }

    static BillDto fromBillToBillDto(Bill bill){
        return BillDto
                .builder()
                .id(bill.getId())
                .totalPrice(bill.getTotalPrice())
                .build();
    }

    static List<ProductDto> fromProductListToProductDtoList(List<Product> productList){
        return productList
                .stream()
                .map(Mapper::fromProductToProductDto)
                .collect(Collectors.toList());
    }

}
