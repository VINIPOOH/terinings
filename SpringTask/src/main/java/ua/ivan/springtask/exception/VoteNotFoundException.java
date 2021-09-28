package ua.ivan.springtask.exception;

public class VoteNotFoundException extends RuntimeException {
    public VoteNotFoundException() {}

    public VoteNotFoundException(String message) {
        super(message);
    }
}
