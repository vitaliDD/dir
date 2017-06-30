package cw18;

import java.util.ArrayList;

public class StaffCollection<T extends People>{
    
    
    private ArrayList<T> list=new ArrayList<>();
    
    
    public void add(T t){
    
    list.add(t);
    }
    
    
    public void remove(T t){
    
    list.remove(t);
    
    }
    
    addDirector();
    addDepartment();
    add();
    remove();
    removeAllDepartment();
    Public T getDirector();
}
