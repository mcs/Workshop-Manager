package model;

import java.util.List;
import javax.persistence.*;

@Entity
@NamedQueries({
    @NamedQuery(name = Workshop.FIND_BY_NAME, query = "SELECT w FROM Workshop w WHERE w.name = :name"),
    @NamedQuery(name = Workshop.FIND_ALL, query = "SELECT w FROM Workshop w")
})
public class Workshop extends AbstractEntity {

    public static final String FIND_BY_NAME = "workshop.findByName";
    public static final String FIND_ALL = "workshop.findAll";
    private static final long serialVersionUID = 1L;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(nullable = false)
    private int punkte;
    @ManyToMany
    private List<Person> participants;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPunkte() {
        return punkte;
    }

    public void setPunkte(int punkte) {
        this.punkte = punkte;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Person> participants) {
        this.participants = participants;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Workshop other = (Workshop) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Workshop{" + "name=" + name + ", participants=" + participants + '}';
    }
}
