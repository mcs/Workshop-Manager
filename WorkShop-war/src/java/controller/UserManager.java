package controller;

import exception.PasswordWrongException;
import exception.UserNotFoundException;
import helper.FacesMessages;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.User;
import service.LoginService;

@Named
@SessionScoped
public class UserManager implements Serializable {

    private String username, password;
    private User user;
    @EJB
    private LoginService loginService;
    @Inject
    private transient FacesMessages facesMessages;

    public String login() {
        try {
            user = loginService.login(username, password);
            facesMessages.addInfo("Login erfolgreich! Willkommen, " + username);
            return "/manager/list";
        } catch (UserNotFoundException ex) {
            facesMessages.addError("login:username", "Benutzer unbekannt", ex.getLocalizedMessage());
        } catch (PasswordWrongException ex) {
            facesMessages.addError("login:password", "Ungültiges Passwort", ex.getLocalizedMessage());
        }
        return "/login";
    }

    public String logout() {
        user = null;
        facesMessages.addInfo(username + " erfolgreich abgemeldet");
        return "/index";
    }

    public boolean isLoggedIn() {
        return user != null;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
