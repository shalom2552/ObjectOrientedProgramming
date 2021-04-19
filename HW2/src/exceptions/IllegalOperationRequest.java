package exceptions;

public class IllegalOperationRequest extends Exception {
    public IllegalOperationRequest(String errorMessage) {
        super(errorMessage);
    }
}
// TODO post-submission:
// IllegalOperationRequest -> IllegalOperationRequestException
