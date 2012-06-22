package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Password implements Serializable {

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Hashalgorithm hashalgorithm;
    @Column(nullable = false)
    private int wrongLogins;

    public Hashalgorithm getHashalgorithm() {
        return hashalgorithm;
    }

    public void setHashalgorithm(Hashalgorithm hashalgorithm) {
        this.hashalgorithm = hashalgorithm;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getWrongLogins() {
        return wrongLogins;
    }

    public void setWrongLogins(int wrongLogins) {
        this.wrongLogins = wrongLogins;
    }
}
