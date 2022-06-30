package Service;

public class VendingDuplicationException extends Exception {

    public VendingDuplicationException(String message) {
        super(message);
    }

    public VendingDuplicationException(String message,
                                       Throwable cause) {
        super(message, cause);
    }
}