package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 *
 * @author ya
 */
public class SearchDegree extends SearchType {

    public ArrayList<Doctors> searchDegreesOfDoctors(String degree) {
        dL = new ArrayList<>();
        for (int i = 0; i < Manager.getdList().size(); i++) {
            if (Manager.getdList().get(i).getDegree().contains(degree)) {
                dL.add(Manager.getdList().get(i));
            }
        }
        return dL;
    }

    public HashMap<Integer, String> getDegreesOfDoctors() {

        HashSet<String> hs = new HashSet<>();
        for (Doctors d : Manager.getdList()) {
            hs.add(d.getDegree());
        }
        ArrayList<String> al = new ArrayList<>(hs);
        HashMap<Integer, String> hm = new HashMap<>();
        for (int i = 0; i < hs.size(); i++) {
            hm.put(i, al.get(i));
        }
        return hm;

    }

}
