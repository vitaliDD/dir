package New3;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class NewMain {

    public static void main(String[] args) {
        
        
        MyTest myTest= new MyTest();
        
        
        Class clas=myTest.getClass();
        
        
        System.out.println(clas.getSimpleName());
        System.out.println(clas.getName());
        
        int mode=clas.getModifiers();
       
        if(Modifier.isPublic(mode)){
            System.out.println("class publichnii");
        
            
        
        }if(Modifier.isAbstract(mode)){
        
            System.out.println("astractnii");
        }
        Field[] fields=clas.getDeclaredFields();
        for(Field f:fields)
            System.out.println("peremennaya "+f);
        
        
    }
    
}
