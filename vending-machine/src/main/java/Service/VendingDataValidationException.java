package Service;

public class VendingDataValidationException extends Exception{

    public VendingDataValidationException(String message) {
        super(message);
    }

    public VendingDataValidationException(String message,
                                              Throwable cause) {
        super(message, cause);
    }

}