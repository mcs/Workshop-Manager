package controller.user;

import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import model.Workshop;

@Named
@RequestScoped
public class MyWorkshopsBean {

    private List<Workshop> workshops = new ArrayList<Workshop>();

    public List<Workshop> getWorkshops() {
        // TODO : Replace with real impl
        workshops.clear();
        for (int i = 0; i < 3; i++) {
            Workshop w = new Workshop();
            w.setId(42L + i);
            w.setName(String.format("My %d. Workshop", i+1));
            workshops.add(w);
        }
        return workshops;
    }
}
