package exception;

public class WorkshopException extends Exception {

    private static final long serialVersionUID = 1L;

    public WorkshopException() {
        super();
    }

    public WorkshopException(String message, Throwable cause) {
        super(message, cause);
    }

    public WorkshopException(String message) {
        super(message);
    }

    public WorkshopException(Throwable cause) {
        super(cause);
    }
}
