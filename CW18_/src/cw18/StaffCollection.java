package cw18;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StaffCollection<T extends People>{
    
    private HashMap<String, List <T>> data = new HashMap<>();
    private T director;
    //private ArrayList<T> list=new ArrayList<>();
    
    
    public void add(T t){
    
    list.add(t);
    }
    public void add(String department, T value){
        if(data.containsKey(department)){
        
            data.get(department).add(value);
        
        }
        else{
        
            List<T> list =data.get(department);
            if(list==null){
                list=new ArrayList<>();
                
            }
            list.add(value);
            data.put(department, list);
        }

    }
    
    public void addDirector(T value){
        director=value;
    }
    
    public T getDirector(){
        return director;
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
