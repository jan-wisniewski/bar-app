package wisniewski.jan.exceptions;

public class ProductServiceException extends RuntimeException{
    public ProductServiceException(String message) {
        super(message);
    }
}
