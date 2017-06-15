/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz10;

/**
 *
 * @author Doshchechko
 */
public class MyException  extends Exception{
String message;

   

   

 
    
    
    public void getRussianException(){
     // System.out.println("Произошла страшная ошибка!!");
      System.err.println("Сработало исключение неправильного знака!!");
   
    }
}
