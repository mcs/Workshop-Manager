package service;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class DeleteWorkshopService {

    @EJB
    WorkshopService workshopService;
    
    public void deleteById(long id) {
        workshopService.deleteById(id);
    }

}
