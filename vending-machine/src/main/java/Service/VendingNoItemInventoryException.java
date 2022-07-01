package Service;

public class VendingNoItemInventoryException extends Exception{

    public VendingNoItemInventoryException(String message) {
        super(message);
    }

    public VendingNoItemInventoryException(String message,
                                           Throwable cause) {
        super(message, cause);
    }

}