package model;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "users")
@NamedQueries({
    @NamedQuery(name = "user.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
})
public class User extends AbstractEntity {

    private static final long serialVersionUID = 1L;
    @Column(unique = true, nullable = false)
    private String username;
    @Embedded
    private Password password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Hashalgorithm hashalgorithm;
    @Column(nullable = false)
    private int wrongLogins;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin = new Date();
    @Enumerated(EnumType.STRING)
    @Column(name = "userrole", nullable = false)
    private Role role;

    public void clear() {
        username = null;
        password = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public Hashalgorithm getHashalgorithm() {
        return hashalgorithm;
    }

    public void setHashalgorithm(Hashalgorithm hashalgorithm) {
        this.hashalgorithm = hashalgorithm;
    }

    public int getWrongLogins() {
        return wrongLogins;
    }

    public void setWrongLogins(int wrongLogins) {
        this.wrongLogins = wrongLogins;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
