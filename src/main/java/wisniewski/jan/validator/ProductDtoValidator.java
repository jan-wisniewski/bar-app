package wisniewski.jan.validator;

import lombok.extern.slf4j.Slf4j;
import wisniewski.jan.dtos.ProductDto;
import wisniewski.jan.validator.base.Validator;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ProductDtoValidator implements Validator<ProductDto> {

    @Override
    public Map<String, String> validate(ProductDto item) {
        Map<String, String> errors = new HashMap<>();
        if (!isNameStartsFromUppercase(item)) {
            errors.put("Name", "Should start from uppercase");
        }
        if (!isPricePositive(item)) {
            errors.put("Price", "Should be positive");
        }
        return errors;
    }


    private boolean isNameStartsFromUppercase(ProductDto productDto) {
        return productDto.getName().matches("[A-Z]+[a-z]*");
    }

    private boolean isPricePositive(ProductDto productDto) {
        return productDto.getPrice().compareTo(BigDecimal.ZERO) > 0;
    }

}
