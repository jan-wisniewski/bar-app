package wisniewski.jan.validator;

import wisniewski.jan.dtos.OrderDto;

import java.util.HashMap;
import java.util.Map;

public class OrderDtoValidator implements Validator<OrderDto> {

    @Override
    public Map<String, String> validate(OrderDto item) {
        Map<String, String> errors = new HashMap<>();
        if (!isValidProductList(item)) {
            errors.put("Product List", "Shoud contain at least one product");
        }
        return errors;
    }

    private boolean isValidProductList(OrderDto orderDto) {
        return orderDto.getProductIds() != null && orderDto.getProductIds().size() > 0;
    }

}
