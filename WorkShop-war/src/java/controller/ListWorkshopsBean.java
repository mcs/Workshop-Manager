package controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Workshop;
import service.WorkshopService;

@Named
@RequestScoped
public class ListWorkshopsBean {

    private List<Workshop> workshops = new ArrayList<Workshop>();
    @EJB
    WorkshopService workshopService;

    public List<Workshop> getWorkshops() {
        workshops =workshopService.getAll();
        return workshops;
    }
}
