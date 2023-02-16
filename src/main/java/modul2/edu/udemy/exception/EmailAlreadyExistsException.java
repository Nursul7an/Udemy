package modul2.edu.udemy.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException() {
    }
    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
