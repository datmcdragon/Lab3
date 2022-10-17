package task2.exceptions;

public class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
        super(message);
    }

    public InvalidPriceException() {
        super("Price is invalid");
    }
}
