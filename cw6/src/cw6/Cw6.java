/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw6;

/**
 *
 * @author user
 */
public class Cw6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
       /* Car red=new Red();
        Car blue=new Blue();
        printColor(red);
        printColor(blue);
     
    
    }
    
    
    
    
    public static void printColor(Car car){
       if(car instanceof Red){
           Red car2=(Red) car;
           car2.test();
       }
        
    System.out.println(car.getColor());*/
       
       Figure fig1=new Circle(3);
       Figure fig2=new Triangle(3,3);
       Figure fig3=new Square(3);
       getA(fig1);
       getA(fig2);
       getA(fig3);
      
       
       
       }
      // System.out.println(fig1.getArea());
     //  System.out.println(fig2.getArea());
      // System.out.println(fig3.getArea());
           static void getA(Figure f){
          System.out.println( f.getArea());
}   
    }
    


