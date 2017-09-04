package dz19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jdk.nashorn.internal.ir.BreakNode;

public class StaffCollection<T extends People> {

    private HashMap<String, List<T>> data = new HashMap<>();
    private T director;

    @Override
    public String toString() {
        return "StaffCollection{" + "data=" + data + ", director=" + director + '}';
    }

    public void add(String department, T value) {
        if (data.containsKey(department)) {

            data.get(department).add(value);
        } else {

            List<T> list = data.get(department);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(value);
            data.put(department, list);
        }

    }

    public void addDirector(T value) {
        director = value;
    }

    public T getDirector() {
        return director;
    }

    public void removeElementByValue(String department, T value) {
        if (data.containsKey(department)) {
            if (data.get(department).contains(value)) {
                int i = data.get(department).indexOf(value);
                data.get(department).remove(i);
            } else {
                System.out.println("Departament " + department + " est', no net takogo elementa");
            }

        } else {

            System.out.println("Departament " + department + " otsytstvyet");

        }

    }

    public void removeAllFromDepartment(String department, T value) {
        if (data.containsKey(department)) {
            data.get(department).clear();
        } else {
            System.out.println("Departament " + department + " ne sozdano");
        }

    }

    //public Iterator<T> iterator(String department) {
    public Iterator<T> iterator() {

        int keysSize = data.keySet().size();
        return new Iterator<T>() {
            Iterator<T> elementIt = null;
            Iterator keysIt = null;
            String keyInd = null;

            @Override
            public boolean hasNext() {
                return false;

            }

            @Override
            public T next() {

                if (!data.keySet().isEmpty()) {
                    if (keysIt == null) {
                        keysIt = data.keySet().iterator();
                    }
                    if (keyInd == null) {
                        keyInd = (String) keysIt.next();
                        // System.out.println("voshlo v (String) keysIt.next()");
                    }
                    while (true) {

                        //  System.out.println(keyInd);
                        //  System.out.println(data.get(keyInd).isEmpty());
                        if (!data.get(keyInd).isEmpty()) {
                            //System.out.println("voshlo v !data.get(keyInd).isEmpty()");
                            if (elementIt == null) {
                                //  System.out.println("voshlo v elementIt == null)");
                                elementIt = data.get(keyInd).iterator();
                            }
                            while (elementIt.hasNext()) {
                                // System.out.println("voshlo v elementIt.hasNext");
                                return elementIt.next();
                            }
                            //  System.out.println("vihod iz elementIt.hasNext");
                        }else{
                        // System.out.println("vihod iz if(!data.get(keyInd).isEmpty()");
                            System.out.println("Otdel "+keyInd+" pustoi! Vseh uvolili!");
                        }
                        if (keysIt.hasNext()) {
                            keyInd = (String) keysIt.next();
                            elementIt = null;
                        } else {
                            break;
                        }

                    }
                }
                return null;
            }

        };
    }
}
