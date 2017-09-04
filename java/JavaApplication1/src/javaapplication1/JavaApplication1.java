/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author user
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double cost=860.0/23/180/60;
        long curTime = System.currentTimeMillis();
        String curStringD = new SimpleDateFormat("hhmmss").format(curTime); 
        int CT=Integer.parseInt(curStringD);
        int ST=63000;
        int chas1=3600*(CT/10000);
        int chas2=3600*(ST/10000);
        int min1=60*((CT/100)%100);
        int min2=60*((ST/100)%100);
        int sec1=CT%100;
        int sec2=ST%100;
        int allSec1=chas1+min1+sec1; //текущее
        int allSec2=chas2+min2+sec2; //начальное
        double RESULT=(allSec1-allSec2)*cost;
        int aa=5;
        String x=String.valueOf(aa);
        System.out.println(new Date(System.currentTimeMillis()));
        System.out.println("1 секунда занятий стоит "+cost+" рубля");
        int a=6;
        switch(a){
            
            case  (5): {
                System.out.println("a = 5");
                break;
            }    
            
            case  (6):{
                //System.out.println("a = 6");
            
                 break;
            }
            
            default: {
                System.out.println("тут default");
                        } 
        
    }
        
        int mass0[]=new int[5];
        int mass1[]={1,2,3};
        float mass2[]={1.0f,2.0f,3.6f};
        
        double mass3[]={1.0,2.0,3.6,5.5,4.6};
        int i=2;
        for(;i<mass3.length;i++){
            System.out.println(mass3[i]);
        
        }
      /*
        System.out.println(curTime);
        System.out.println(CT);
        System.out.println(ST);
        System.out.println(Res);
        System.out.println(sec1);
        System.out.println(sec2);
        System.out.println(min1);
        System.out.println(min2);
        System.out.println(chas1);
        System.out.println(chas2);
        System.out.println(allSec1);
        System.out.println(allSec2);
        System.out.println(x);
*/
        System.out.println("На данный момент мы потратили "+RESULT+" рублей");
        System.out.println("В пивном эквиваленте  "+(int)(RESULT/1.5)+" бутылок 0.5!!!");
        
     
    }
    
}
