package controller.manager;

import helper.FacesMessages;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import service.DeleteWorkshopService;

@Named
@RequestScoped
public class DeleteWorkshopBean {

    @EJB
    private DeleteWorkshopService deleteWorkshopService;
    @Inject
    private FacesMessages facesMessages;

    public String delete(long id) {
        deleteWorkshopService.deleteById(id);
        facesMessages.addInfo("Workshop erfolgreich gelöscht.");
        return "/manager/list";
    }

}
