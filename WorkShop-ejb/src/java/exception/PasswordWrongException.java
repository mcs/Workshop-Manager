package exception;

public class PasswordWrongException extends WorkshopException {

    private static final long serialVersionUID = 1L;
    private final String username;
    private final String password;

    public PasswordWrongException(String username, String password) {
        super(String.format("Username '%s' does not have the password '%s'", username, password));
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
