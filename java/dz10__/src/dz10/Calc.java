/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dz10;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Doshchechko
 */
public class Calc {

    static void Podschet() throws MyDevideZeroException{
        String s = ConsVvod.vvod();
        String[] sArray = s.split("\\D");
        //if(sArray[0])
        //char znak ='2';
        char znak = s.charAt(sArray[0].length());
        //System.out.println(znak);
        if (znak != '+'&& znak != '-'&& znak != '/' && znak != '*') {
       
            //System.err.println("fdfdf"); 
            try {
                throw new MyException();
            } catch (MyException ex) {
                //System.err.println("fdfdf"); 
               // ex.getRussianException();
                ex.getRussianException();
                
            }
        }

        double chisl1 = 0.0;
        double chisl2 = 0.0;
     
            chisl1 = Double.valueOf(sArray[0]);
            chisl2 = Double.valueOf(sArray[1]);
       

        switch (znak) {

            case '+':
                System.out.println(chisl1 + chisl2);
                //  return sArray[0]+sArray[1];
                break;
            case '-':
                System.out.println(chisl1 - chisl2);
                // return sArray[0]-sArray[1];
                break;
            case '/':
              if (chisl2 == 0) {
                    throw new MyDevideZeroException();
                }
                System.out.println(chisl1 / chisl2);
                //   return sArray[0]+sArray[1];
                break;
            case '*':
                System.out.println(chisl1 * chisl2);
                //   return sArray[0]+sArray[1];

                break;

        }

    }

}
