package exception;

public class UserNotFoundException extends WorkshopException {

    private static final long serialVersionUID = 1L;
    private final String username;

    public UserNotFoundException(String username) {
        super(String.format("User '%s' not found", username));
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
