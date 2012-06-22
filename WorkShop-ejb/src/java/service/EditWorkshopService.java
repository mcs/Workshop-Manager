package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Workshop;

@Stateless
@LocalBean
public class EditWorkshopService {

    @PersistenceContext
    EntityManager em;

    public Workshop get(Long id) {
        return em.find(Workshop.class, id);
    }
    
    public void editWorkshop(Long id, String name, int punkte) {
        Workshop w = em.find(Workshop.class, id);
        w.setName(name);
        w.setPunkte(punkte);
    }

}
