package wisniewski.jan.validator;

import lombok.extern.slf4j.Slf4j;
import wisniewski.jan.dtos.PaymentDto;
import wisniewski.jan.enums.PaymentType;
import wisniewski.jan.validator.base.Validator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class PaymentDtoValidator implements Validator<PaymentDto> {

    @Override
    public Map<String, String> validate(PaymentDto item) {
        Map<String, String> errors = new HashMap<>();
        log.warn("" + isCorrectPaymentType(item));
        if (!isCorrectPaymentType(item)) {
            log.warn("Payment: " +item);
            String availablePaymentsType = Arrays.stream(PaymentType.values()).map(Enum::name).collect(Collectors.joining(","));
            errors.put("PaymentType", "Should be one of the: " + availablePaymentsType);
        }
        return errors;
    }

    private boolean isCorrectPaymentType(PaymentDto paymentDto) {
        log.warn("Payment: " +paymentDto);
        return Arrays
                .stream(PaymentType.values())
                .filter(v -> v.name().equals(paymentDto.getPaymentType()))
                .count() == 1;
    }

}
