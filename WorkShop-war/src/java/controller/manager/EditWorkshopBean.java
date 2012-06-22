package controller.manager;

import helper.FacesMessages;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Workshop;
import service.EditWorkshopService;

@Named
@RequestScoped
public class EditWorkshopBean {

    private Workshop workshop = new Workshop();
    @EJB
    private EditWorkshopService editWorkshopService;
    @Inject
    private FacesMessages facesMessages;

    public String edit(long workshopId) {
        workshop = editWorkshopService.get(workshopId);
        return "/manager/edit";
    }

    public String save() {
        editWorkshopService.editWorkshop(workshop.getId(), workshop.getName(), workshop.getPunkte());
        facesMessages.addInfo("Workshop erfolgreich geändert.");
        return "/manager/list";
    }

    public Workshop getWorkshop() {
        return workshop;
    }

    public void setWorkshop(Workshop workshop) {
        this.workshop = workshop;
    }
}
