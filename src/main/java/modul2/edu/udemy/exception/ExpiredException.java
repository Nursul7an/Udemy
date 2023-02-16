package modul2.edu.udemy.exception;

public class ExpiredException extends RuntimeException{
    public ExpiredException() {
    }
    public ExpiredException(String message) {
        super(message);
    }
}
