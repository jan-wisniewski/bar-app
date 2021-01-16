package wisniewski.jan.validator;

import java.util.HashMap;
import java.util.Map;

public interface Validator<T> {
    Map<String, String> validate(T item);
}
