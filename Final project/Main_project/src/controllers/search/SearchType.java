package controllers.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import models.entity.Doctors;
import controllers.manager.Manager;

public class SearchType {

    protected ArrayList<Doctors> dL;

    public ArrayList<Doctors> searchTypesOfDoctors(String spec) {
        dL = new ArrayList<>();
        for (int i = 0; i < Manager.getdList().size(); i++) {
            if (Manager.getdList().get(i).getType().contains(spec)) {
                dL.add(Manager.getdList().get(i));
            }
        }
        return dL;
    }

    public HashMap<Integer, String> getTypesOfDoctors() {

        HashSet<String> hs = new HashSet<>();
        for (Doctors d : Manager.getdList()) {
            hs.addAll(d.getType());
        }
        ArrayList<String> al = new ArrayList<>(hs);
        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 0; i < hs.size(); i++) {
            hm.put(i, al.get(i));
        }
        return hm;

    }
}
