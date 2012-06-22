package service;

import exception.PasswordWrongException;
import exception.UserNotFoundException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import model.Hashalgorithm;
import model.User;

@Stateless
public class LoginService {

    @PersistenceContext
    EntityManager em;

    /**
     * Tries to login a user. This method does nothing more than checking user
     * credentials and returning a matching user object. If for example the
     * password is wrong, the login error count won't be incremented
     * automatically. This must be explicitly done.
     *
     * @param username the username
     * @param password the unencrypted password
     * @return the user entity
     * @throws UserNotFoundException if no user was found for the given username
     * @throws PasswordWrongException if password does not match the user's one
     */
    public User login(String username, String password) throws UserNotFoundException, PasswordWrongException {
        try {
            return loadUserAndCheckCredentials(username, password);
        } catch (NoResultException e) {
            throw new UserNotFoundException(username);
        }
    }

    private User loadUserAndCheckCredentials(String username, String password) throws PasswordWrongException, RuntimeException {
        // load user
        User user = (User) em.createNamedQuery("user.findByUsername").setParameter("username", username).getSingleResult();
        // check password
        Hashalgorithm hashalgorithm = user.getHashalgorithm();
        String hashedPassword;
        switch (hashalgorithm) {
            case PLAIN:
                hashedPassword = password;
                break;

            default:
                throw new RuntimeException(String.format("Encountered unexpectedted algorithm for user '%s': '%s'", username, hashalgorithm.name()));
        }
        if (!user.getPassword().getPassword().equals(hashedPassword)) {
            throw new PasswordWrongException(username, password);
        }
        return user;
    }
}
