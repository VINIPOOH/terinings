package ua.ivan.springtask.exception;

public class UserNotAuthenticatedException extends RuntimeException{

    public UserNotAuthenticatedException() {}

    public UserNotAuthenticatedException(String message) {
        super(message);
    }
}
