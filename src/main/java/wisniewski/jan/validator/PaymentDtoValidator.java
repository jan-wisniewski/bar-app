package wisniewski.jan.validator;

import lombok.extern.slf4j.Slf4j;
import wisniewski.jan.dtos.PaymentDto;
import wisniewski.jan.enums.PaymentType;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class PaymentDtoValidator implements Validator<PaymentDto> {

    @Override
    public Map<String, String> validate(PaymentDto item) {
        Map<String, String> errors = new HashMap<>();
        if (!isCorrectPaymentType(item)) {
            errors.put("PaymentType", "Should be one of the: " + Arrays.stream(PaymentType.values()));
        }
        return errors;
    }

    private boolean isCorrectPaymentType(PaymentDto paymentDto) {
        return Arrays
                .stream(PaymentType.values())
                .filter(v -> v.name().equals(paymentDto.getPaymentType()))
                .count() == 1;
    }

}
