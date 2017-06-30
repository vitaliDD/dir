package New3;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class NewMain {

    public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
        
        
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
        for(Field f:fields){
            System.out.println("peremennaya "+f);
            f.setAccessible(true);
            
             Object obj=f.get(myTest);
             
             
             if(obj instanceof String){
                 System.out.println("value = "+(String)obj);
                 f.set(myTest,"afagadga");
                 System.out.println("value = "+(String)f.get(myTest) );
                 
             }
             
                }
        
        
    }
    
}
