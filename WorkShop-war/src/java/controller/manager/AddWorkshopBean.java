package controller.manager;

import helper.FacesMessages;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import model.Workshop;
import service.AddWorkshopService;

@Named
@RequestScoped
public class AddWorkshopBean {

    private Workshop workshop = new Workshop();
    @EJB
    private AddWorkshopService addWorkshopService;
    @Inject
    private FacesMessages facesMessages;

    public String form() {
        return "/manager/add";
    }

    public String add() {
        System.out.println("Add() aufgerufen! Workshop = " + workshop);
        addWorkshopService.addWorkshop(workshop.getName());
        facesMessages.addInfo("Ein neuer Workshop wurde angelegt.");
        return "/manager/list";
    }

    public Workshop getWorkshop() {
        return workshop;
    }
}
