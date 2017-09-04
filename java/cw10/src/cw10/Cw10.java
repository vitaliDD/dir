
package cw10;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Cw10 {

    public void method (Object e){
        System.out.println("obj");
    }    
     public void method (Exception e){
        System.out.println("ex");
    }   
    public void method (FileNotFoundException e){
     System.out.println("file");
    }
    public void method (IOException e){
     System.out.println("io");
    }
    public static void main(String[] args) {
        
        
        
        
        
        Cw10 p=new Cw10();
        
        p.method(new Exception());
        try {
            p.error();
        } catch (Exception ex) {
        }
        
        
        try{
        
        }catch(ArrayIndexOutOfBoundsException e ){
        
        
        }catch(Exception e){
        
        }
       
    }
    public void error()throws Exception{
        error2();
    
    }
    public void error2()throws Exception{
        
    
    }
}
