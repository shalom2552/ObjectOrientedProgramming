package exceptions;

public class CustomerNotListedException extends Exception{

    public CustomerNotListedException(String errorMessage) {
        super(errorMessage);
    }
}

