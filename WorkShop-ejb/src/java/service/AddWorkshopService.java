package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Workshop;

@Stateless
@LocalBean
public class AddWorkshopService {

    @PersistenceContext
    EntityManager em;
    
    public void addWorkshop(String name) {
        Workshop w = new Workshop();
        w.setName(name);
        em.persist(w);
    }

}
