package service;

import exception.BusinessException;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Workshop;

@Stateless
public class WorkshopService {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    public List<Workshop> getAll() {
        return em.createNamedQuery(Workshop.FIND_ALL).getResultList();
    }

    public Workshop readById(Long id) {
        return em.find(Workshop.class, id);
    }

    public void add(Workshop workshop) {
        em.persist(workshop);
    }

    public Workshop deleteById(Long id) {
        Workshop workshop = em.find(Workshop.class, id);
        if (workshop != null) {
            em.remove(workshop);
        }
        return workshop;
    }

    public void update(Workshop workshop) {
        Workshop existing = (Workshop) em.createNamedQuery("workshop.findByName").setParameter("name", workshop.getName()).getSingleResult();
        if (existing == null || existing.getId().equals(workshop.getId())) {
            em.merge(workshop);
        } else {
            throw new BusinessException(
                    "error.workshop.nameExists",
                    workshop.getName());
        }
    }
}