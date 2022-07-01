package Service;

public class VendingInsufficientFundsException extends Exception {

    public VendingInsufficientFundsException(String message) {
        super(message);
    }

    public VendingInsufficientFundsException(String message,
                                             Throwable cause) {
        super(message, cause);
    }
}