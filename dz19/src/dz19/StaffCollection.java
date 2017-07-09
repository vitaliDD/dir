package dz19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jdk.nashorn.internal.ir.BreakNode;

public class StaffCollection<T extends People> {

    private HashMap<String, List<T>> data = new HashMap<>();
    private T director;
    Iter iter=new Iter(newArray);
    //private ArrayList<T> list=new ArrayList<>();

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
            }
            else
                System.out.println("Departament "+department+" est', no net takogo elementa");
            
        } else {

             System.out.println("Departament "+department+" otsytstvyet");

            }
            
        }
    public void removeAllFromDepartment(String department, T value) {
        if (data.containsKey(department)) {
           data.get(department).clear();
            }
            else
                System.out.println("Departament "+department+" ne sozdano");
            
        }

    }

   
