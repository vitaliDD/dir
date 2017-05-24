/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz2;

import java.util.Random;

/**
 *
 * @author ya
 */
public class Dz2 {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    
        //zadanie 1
        System.out.println("задание 1");
        int[] mass1=new int[10];
        Random rand=new Random();
        System.out.print("исходный массив: ");
        for(int i=0;i<mass1.length;i++){
            mass1[i]=rand.nextInt(100);
            System.out.print(mass1[i]+" ");
        }
        System.out.println();
        int min_value=mass1[0];
        int max_value=0;
        

        for(int i=0;i<mass1.length;i++){
           
        }
        
         //zadanie 2
        System.out.println("задание 2");
        
        float[] mass2={1,8,3,4,6,3,4,9,8,8};

        System.out.print("исходный массив: ");
        for(int i=0;i<mass2.length;i++){
            System.out.print(mass2[i]+" ");
            
        }
        System.out.println();
        int flag=1;
        for (int i=0;i<mass2.length-1;i++){
            for(int j=i+1;j<mass2.length;j++){
                if(mass2[i]==mass2[j]){
                flag++;
                }
            }
            if(flag!=1){
                System.out.println("["+mass2[i]+"] - повторений "+flag);
                flag=1;
            }
        }
        
    }
    
}
