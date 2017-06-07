/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cw7;

import java.util.Collections;
import javax.xml.bind.Marshaller;

/**
 *
 * @author user
 */
public class Cw7 implements OnclickListener{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cw7 main=new Cw7();
        
       
        
        Button button =new Button();
        button.setListener(main);
        button.onTouch();
        
       
    
    }

    @Override
    public void onClick() {
        System.out.println("On click v Main");
    }
    
    
    
    
}
